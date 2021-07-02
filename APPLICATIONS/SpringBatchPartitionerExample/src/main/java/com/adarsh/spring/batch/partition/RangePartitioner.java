package com.adarsh.spring.batch.partition;

import org.apache.log4j.Logger;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.util.HashMap;
import java.util.Map;

public class RangePartitioner implements Partitioner {

    private final static Logger RangePartitioner = Logger.getLogger(RangePartitioner.class);
	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		final Map<String, ExecutionContext> result = new HashMap<String, ExecutionContext>();
		int range = 10;
		int fromId = 1;
		int toId = range;
		for (int i = 1; i <= gridSize; i++) {
			final ExecutionContext value = new ExecutionContext();
			RangePartitioner.info("\nStarting : Thread" + i);
			RangePartitioner.info("fromId : " + fromId);
			RangePartitioner.info("toId : " + toId);
			value.putInt("fromId", fromId);
			value.putInt("toId", toId);
			// give each thread a name
			value.putString("name", "Thread" + i);
			result.put("partition" + i, value);
			fromId = toId + 1;
			toId += range;
		}
		return result;
	}
}
