package org.frm.utn.util;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFileTree implements FileVisitor<Path> {
	
	private Path source;
	private Path target;
	
	
	

	public CopyFileTree(Path source, Path target) {
		super();
		this.source = source;
		this.target = target;
	}
	
	/**
	 * Los cuatro métodos de interfaz nos permiten especificar 
	 * el comportamiento requerido en los puntos clave del proceso transversal: 
	 *  antes de acceder a un directorio,
	 *  cuando se visita un archivo o 
	 *  cuando ocurre una falla y 
	 *  después de acceder a un directorio respectivamente.
	 */

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		/**
		 * Indicamos que el recorrido del árbol de archivos debe continuar 
		 * después de que el método que lo devuelve salga 
		 */
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		
		Path newDir= target.resolve(source).relativize(dir);
		try {
			Files.copy(dir, newDir);
		}catch(FileAlreadyExistsException e) {
			
		}catch(IOException e) {
			System.err.format("No se puede crear %s: %s%n:", newDir,e);
			return FileVisitResult.SKIP_SUBTREE;
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		Path newDir = target.resolve(source.relativize(file));
		try {
			Files.copy(file, newDir,java.nio.file.StandardCopyOption.REPLACE_EXISTING);
		}catch(IOException e) {
			System.err.format("No se puede copiar %s: %s%n ", source,e);
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		if(exc instanceof FileSystemLoopException) {
			System.out.println("Ciclo detectado: "+ file);
		}else {
			System.err.format("No se puede copiar: %s: %s%n",file, exc);
		}
		return FileVisitResult.CONTINUE;
	}

}
