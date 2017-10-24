package project2;

import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapOutputCollector.Context;
import org.apache.hadoop.mapreduce.Mapper;

public class TotalSoldMapper extends Mapper<LongWritable,Text,Text,IntWritable> {
	public void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException
	{
		String[] linearray=value.toString().split(Pattern.quote("|"));
		if(!linearray[0].equals("NA"))
		{
			Text name=new Text(linearray[0]);
			
			IntWritable count=new IntWritable(1);
			context.write(name,count);
		}

	}
}
