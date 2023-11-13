package n1Exercici2;

import static java.nio.file.FileVisitResult.CONTINUE;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.TreeSet;

public class Visitor implements FileVisitor<Path> {
			
	TreeSet<String> fileList = new TreeSet<>();
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		
		fileList.add("D " + dir.toString());

		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (attrs.isSymbolicLink()) {

			fileList.add("S " + file.toString() + " " + attrs.lastModifiedTime());

		} else if (attrs.isRegularFile()) {

			fileList.add("F " + file.toString() + " " + attrs.lastModifiedTime());
			
		} else {

			fileList.add("O " + file.toString() + " " + attrs.lastModifiedTime());

		}

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