package com.saif.familytree.utils.volley;

public interface ProgressListener {
    /**
		 * Callback method thats called on each byte transfer.
		 */
		void onProgress(long transferredBytes, long totalSize);
	}