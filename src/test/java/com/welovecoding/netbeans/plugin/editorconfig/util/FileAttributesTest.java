package com.welovecoding.netbeans.plugin.editorconfig.util;

import java.io.File;
import java.net.URL;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FileAttributesTest {

  public FileAttributesTest() {
  }

  @Test
  public void itDetectsFinalNewLineFromUnix() {
    String testFilePath = "org/editorconfig/example/utf8_final_newline_n.txt";
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    URL resource = classLoader.getResource(testFilePath);
    File testFile = new File(resource.getFile());

    boolean hasFinalNewLine = FileAttributes.hasFinalNewLine(testFile);
    assertEquals(true, hasFinalNewLine);
  }

  @Test
  public void itDetectsFinalNewLineFromWindows() {
    String testFilePath = "org/editorconfig/example/utf8_final_newline_rn.txt";
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    URL resource = classLoader.getResource(testFilePath);
    File testFile = new File(resource.getFile());

    boolean hasFinalNewLine = FileAttributes.hasFinalNewLine(testFile);
    assertEquals(true, hasFinalNewLine);
  }

  @Test
  public void itDetectsFinalNewLineInSmallFiles() {
    String testFilePath = "org/editorconfig/example/utf8_final_newline_1_character.txt";
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    URL resource = classLoader.getResource(testFilePath);
    File testFile = new File(resource.getFile());

    boolean hasFinalNewLine = FileAttributes.hasFinalNewLine(testFile);
    assertEquals(true, hasFinalNewLine);
  }

  @Test
  public void itDetectsMissingFinalNewLine() {
    String testFilePath = "org/editorconfig/example/utf8_no_final_newline.txt";
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    URL resource = classLoader.getResource(testFilePath);
    File testFile = new File(resource.getFile());

    boolean hasFinalNewLine = FileAttributes.hasFinalNewLine(testFile);
    assertEquals(false, hasFinalNewLine);
  }

  @Test
  public void itDetectsMissingFinalNewLineInSmallFiles() {
    String testFilePath = "org/editorconfig/example/utf8_no_final_newline_1_character.txt";
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    URL resource = classLoader.getResource(testFilePath);
    File testFile = new File(resource.getFile());

    boolean hasFinalNewLine = FileAttributes.hasFinalNewLine(testFile);
    assertEquals(false, hasFinalNewLine);
  }
}
