package n2Exercici1;

import static java.nio.file.FileVisitResult.CONTINUE;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.TreeSet;

public class Visitor implements FileVisitor<Path> {
			
	TreeSet<Path> fileList = new TreeSet<>();
	HashMap<String, String> attrsMap= new HashMap<>();
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		
		fileList.add(dir);

		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		

			fileList.add(file);
			attrsMap.put(file.getFileName().toString(), attrs.lastModifiedTime().toString());
	

		return CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {

		System.err.println(exc);
		return CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		
		return CONTINUE;
	}
}