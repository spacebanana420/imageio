package imageio.wrapper;

import java.io.IOException;

//Handles process execution, errors/failure, standard input, standard output, etc
public class process {
  public static Process runProcess(String... command) {
    try{return new ProcessBuilder(command).start();}
    catch(IOException e) {return null;}
  }

  public static byte[] runProcess_stdout(String... command) {
    try {
      Process p = runProcess(command);
      if (p == null) return null;
      p.waitFor();
      return p.getInputStream().readAllBytes();}
    catch (IOException | InterruptedException e) {return null;}
  }
}
