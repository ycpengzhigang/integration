package com.min.pattern.paramverification;

import java.io.InputStream;
import java.util.List;

public interface VerificationParser<T> {

	List<T> parse(InputStream  in);
	
}
