package org.example

import org.codehaus.groovy.control.CompilerConfiguration

CompilerConfiguration configuration = new CompilerConfiguration()
configuration.setScriptBaseClass(DelegatingScript.class.getName())
GroovyShell groovyShell = new GroovyShell(this.class.getClassLoader(), new Binding(), configuration)
DelegatingScript script = groovyShell.parse(new File("C:\\Users\\A.Polyakov\\jenkins-groovy-05-2023\\groovy-test\\src\\main\\groovy\\org\\example\\email.dsl"))
def e = new Email()
script.delegate = e
script.run()
