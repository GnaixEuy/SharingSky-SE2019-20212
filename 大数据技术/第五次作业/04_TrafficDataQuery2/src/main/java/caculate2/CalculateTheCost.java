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
import type.BankInfo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 * <p>
 * 项目： bigData-20212
 *
 * @author GnaixEuy
 * @date 2022/4/22
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
public class CalculateTheCost {

    static final String INPUT_PATH = "hdfs://10.211.55.41:9000/input/bank-data.csv";

    static final String OUTPUT_PATH = "hdfs://10.211.55.41:9000/output/bank/4";

    static class MyMapper extends Mapper<LongWritable,Text,BankInfo,LongWritable> {
        @Override
        protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, BankInfo, LongWritable>.Context context) throws IOException, InterruptedException {
            String data = value.toString();
            String[] datas = data.split(",");
            for (int i = 0; i < datas.length; i++) {
                datas[i] = datas[i].replaceAll("\"", "");
            }
            context.write(new BankInfo(datas[1], datas[4]), new LongWritable(Long.parseLong(datas[2])));
        }
    }

    static class MyReducer extends Reducer<BankInfo, LongWritable, BankInfo, LongWritable> {
        @Override
        protected void reduce(BankInfo key, Iterable<LongWritable> values, Reducer<BankInfo, LongWritable, BankInfo, LongWritable>.Context context) throws IOException, InterruptedException {
            long sum = 0L;
            for (LongWritable value : values) {
                sum += value.get();
            }
            System.out.println(key.getId()+ "   "+sum);
            context.write(key, new LongWritable(sum));
        }
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Path inpath = new Path(CalculateTheCost.INPUT_PATH);
        Path outpath = new Path(CalculateTheCost.OUTPUT_PATH);
        //判断输出文件的地址是否存在
        FileSystem fs = FileSystem.get(new URI(CalculateTheCost.OUTPUT_PATH), conf);
        if (fs.exists(outpath)) {
            fs.delete(outpath, true);
        }
        //开始数据分析
        Job job = Job.getInstance(conf, "CalculateTheCost");
        //数据从哪读
        FileInputFormat.setInputPaths(job, inpath);
        //结果往哪写
        FileOutputFormat.setOutputPath(job, outpath);
        //用哪个Map函数和Reduce函数
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReducer.class);
        //输出的数据类型是什么
        job.setOutputKeyClass(BankInfo.class);
        job.setOutputValueClass(LongWritable.class);
        //开始运行
        job.waitForCompletion(true);
    }
}
