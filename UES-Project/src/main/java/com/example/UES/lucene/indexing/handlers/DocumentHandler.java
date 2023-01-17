package com.example.UES.lucene.indexing.handlers;

import java.io.File;

import com.example.UES.elastic.model.ArtikalES;

public abstract class DocumentHandler {
	/**
	 * Od prosledjene datoteke se konstruise Lucene Document
	 * 
	 * @param file
	 *            datoteka u kojoj se nalaze informacije
	 * @return Lucene Document
	 */
	public abstract ArtikalES getIndexUnit(File file);
	public abstract String getText(File file);

}
