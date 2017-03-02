package com.awaresec

import scala.sys.process.Process
import scala.sys.process.ProcessIO

object ScanTls {
  def scan(hostname: String): String = {
    val pb = Process(s"/tmp/ssllabs-scan/ssllabs-scan --grade $hostname")
    var output = ""
    val pio = new ProcessIO(_ => (),
      stdout => scala.io.Source.fromInputStream(stdout)
        .getLines.foreach(output += _),
      _ => ())
    val p = pb.run(pio)
    if (p.exitValue == 0)
      output
    else
      sys.error(s"ssllabs-scan failed with exit code ${p.exitValue}")
  }
}
