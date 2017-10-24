package project2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.ShuffleConsumerPlugin.Context;
import org.apache.hadoop.mapreduce.Reducer;

public class TotalSoldReducer extends Reducer<Text,IntWritable,Text,IntWritable> {
	IntWritable total=new IntWritable();
	public void reduce(Text key,Iterable<IntWritable> values,Context context) throws IOException, InterruptedException
	{
		Integer count=0;
		for(IntWritable value:values)
		{
			count++;
		}
		total.set(count);
		context.write(key,total);
			
	}
}
