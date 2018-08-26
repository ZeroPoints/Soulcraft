package com.zeropoints.soulcraft.capabilities.ghost;

import java.util.concurrent.Callable;
import org.apache.logging.log4j.Level;
import com.zeropoints.soulcraft.Main;

public class GhostFactory implements Callable<IGhost> {

  @Override
  public IGhost call() throws Exception {
	  Main.log(Level.INFO, "Ghost Factory");
	  return new Ghost();
  }
  
}