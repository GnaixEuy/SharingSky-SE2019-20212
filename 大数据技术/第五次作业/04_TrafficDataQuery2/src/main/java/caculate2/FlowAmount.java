package caculate2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * <img src='https://c-ssl.duitang.com/uploads/blog/202008/30/20200830183701_3ZzSR.thumb.1000_0.jpeg'/>
 * <p>
 * 项目： bigData-20212
 *
 * @author GnaixEuy
 * @date 2022/4/19
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
public class FlowAmount {

    static final String INPUT_PATH = "hdfs://10.211.55.41:9000/input/bank-data.csv";

    static final String OUTPUT_PATH = "hdfs://10.211.55.41:9000/output/bank/3";

    static class MyMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
        @Override
        protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context) throws IOException, InterruptedException {
           String data = value.toString();
            String[] datas= data.split(",");
            for (int i = 0; i < datas.length; i++) {
                datas[i] = datas[i].replaceAll("\"", "");
            }
            context.write(new Text(datas[1]),new LongWritable(Long.parseLong(datas[2])));
        }
    }

    static  class  MyReducer extends Reducer<Text,LongWritable,Text,Text> {

        @Override
        protected void reduce(Text key, Iterable<LongWritable> values, Reducer<Text, LongWritable, Text, Text>.Context context) throws IOException, InterruptedException {
            BigDecimal bigDecimal = new BigDecimal(0);
            for (LongWritable value : values) {
                bigDecimal = bigDecimal.add(BigDecimal.valueOf(value.get()));
            }
            System.out.println(bigDecimal);
            context.write(key, new Text(bigDecimal.toString()));
        }
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Path inpath = new Path(FlowAmount.INPUT_PATH);
        Path outpath = new Path(FlowAmount.OUTPUT_PATH);
        //判断输出文件的地址是否存在
        FileSystem fs = FileSystem.get(new URI(OUTPUT_PATH), conf);
        if (fs.exists(outpath)) {
            fs.delete(outpath, true);
        }

        //开始数据分析
        Job job = Job.getInstance(conf, "bigDecimal");
        //数据从哪读
        FileInputFormat.setInputPaths(job, inpath);
        //结果往哪写
        FileOutputFormat.setOutputPath(job, outpath);
        //用哪个Map函数和Reduce函数
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReducer.class);
        //输出的数据类型是什么
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        //开始运行
        job.waitForCompletion(true);
    }

}
