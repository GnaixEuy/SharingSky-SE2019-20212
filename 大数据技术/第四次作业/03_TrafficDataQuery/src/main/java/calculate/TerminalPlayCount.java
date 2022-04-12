package calculate;

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
import java.net.URI;
import java.net.URISyntaxException;

/**
 * <img src="https://c-ssl.duitang.com/uploads/blog/202008/30/20200830183701_3ZzSR.thumb.1000_0.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/4/12
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public class TerminalPlayCount {

    static final String INPUT_PATH1 = "hdfs://10.211.55.41:9000/input/music1.txt";
    static final String INPUT_PATH2 = "hdfs://10.211.55.41:9000/input/music2.txt";
    static final String INPUT_PATH3 = "hdfs://10.211.55.41:9000/input/music3.txt";
    static final String OUTPUT_PATH = "hdfs://10.211.55.41:9000/output/music/2";


    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Path inpath1 = new Path(TerminalPlayCount.INPUT_PATH1);
        Path inpath2 = new Path(TerminalPlayCount.INPUT_PATH2);
        Path inpath3 = new Path(TerminalPlayCount.INPUT_PATH3);
        Path outpath = new Path(OUTPUT_PATH);
        //判断输出文件的地址是否存在
        FileSystem fs = FileSystem.get(new URI(OUTPUT_PATH), conf);
        if (fs.exists(outpath)) {
            fs.delete(outpath, true);
        }

        //开始数据分析
        Job job = Job.getInstance(conf, "terminalplaycount");
        //数据从哪读
        FileInputFormat.setInputPaths(job, inpath1);
        FileInputFormat.addInputPath(job, inpath2);
        FileInputFormat.addInputPath(job, inpath3);
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


    static class MyMapper extends Mapper<LongWritable, Text, Text, LongWritable> { //k1,v1,k2,v2的类型

        @Override
        protected void map(LongWritable key, Text value,
                           Mapper<LongWritable, Text, Text, LongWritable>.Context context)
                throws IOException, InterruptedException {
            String data = value.toString();
            String[] datas = data.split("\t");
            context.write(new Text(datas[5]), new LongWritable(1));
        }
    }


    static class MyReducer extends Reducer<Text, LongWritable, Text, LongWritable> { //k2,v2,k3,v3的类型

        @Override
        protected void reduce(Text k2, Iterable<LongWritable> v2s,
                              Reducer<Text, LongWritable, Text, LongWritable>.Context context) throws IOException, InterruptedException {
            long terminalPlayNum = 0L;
            for (LongWritable ignored : v2s) {
                terminalPlayNum++;
            }
            context.write(k2, new LongWritable(terminalPlayNum));
        }
    }

}
