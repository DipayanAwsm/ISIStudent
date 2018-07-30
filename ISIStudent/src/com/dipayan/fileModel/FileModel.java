/*
	Author:Dipayan
	Date:14-Apr-2018
	Year:2018
	Be Happy , Do what you need to, Do Remember Action Cures Fear
*/
package com.dipayan.fileModel;
import org.springframework.web.multipart.MultipartFile;
public class FileModel {

	private MultipartFile file;

	   public MultipartFile getFile() {
	      return file;
	   }

	   public void setFile(MultipartFile file) {
	      this.file = file;
	   }
}
