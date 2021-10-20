// package io.actbase.testdb.common.infra.web.storage.service;

// import java.nio.file.Path;
// import java.util.stream.Stream;
// import org.springframework.core.io.Resource;
// import org.springframework.web.multipart.MultipartFile;

// /**
//  * The interface Storage service.
//  *
//  * @author eomjeongjae
//  * @since 2019 -09-23
//  */
// public interface StorageService {

//   /**
//    * Init.
//    */
//   void init();

//   /**
//    * Store.
//    *
//    * @param file the file
//    * @param path the path
//    */
//   void store(MultipartFile file, Path path, boolean isSecret);

//   /**
//    * Load all stream.
//    *
//    * @return the stream
//    */
//   Stream<Path> loadAll();

//   /**
//    * Load path.
//    *
//    * @param filename the filename
//    * @return the path
//    */
//   Path load(String filename);

//   /**
//    * Load as resource resource.
//    *
//    * @param filename the filename
//    * @return the resource
//    */
//   Resource loadAsResource(String filename);

//   /**
//    * Delete all.
//    */
//   void deleteAll();

// }
