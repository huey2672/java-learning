package com.huey.learning.java.common.clone.deepcopy.serialization;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Book entity
 *
 * @author huey
 */
@Data
@AllArgsConstructor
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String edition;
	private Person author;
	
}
