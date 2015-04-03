package net.sf.appstatus.services;

public class CachedCallStatistics {

	private CallStatistics direct = new CallStatistics();
	private CallStatistics cache = new CallStatistics();

	public void addCall(Long executionTime, boolean cacheHit, boolean failure, boolean error, int nestedCalls) {

		// Update statistics
		if (cacheHit) {
			cache.addCall(executionTime, failure, error, nestedCalls);
		} else {
			direct.addCall(executionTime, failure, error, nestedCalls);
		}

	}

	public CallStatistics getCacheStatistics() {
		return cache;
	}

	public CallStatistics getDirectStatistics() {
		return direct;
	}

	public long getFailures() {
		return direct.getFailures() + cache.getFailures();
	}

	public long getErrors() {
		return direct.getErrors() + cache.getErrors();
	}

	public long getTotalHits() {
		return direct.getHits() + cache.getHits();
	}

}
