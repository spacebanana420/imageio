package imageio.wrapper;

import java.io.IOException;
import java.io.InputStream;

//Handles process execution, errors/failure, standard input, standard output, etc
public class process {
  // public static Process runProcess(String... command) {
  //   try{return }
  //   catch(IOException e) {return null;}
  // }

  public static byte[] runProcess_stdout(String... command) {
    try {
      Process p = new ProcessBuilder(command).start();
      byte[] stdout = p.getInputStream().readAllBytes();
      p.waitFor();
      if (p.exitValue() != 0) return null;
      return stdout;
    }
    catch (IOException | InterruptedException e) {return null;}
  }
}
