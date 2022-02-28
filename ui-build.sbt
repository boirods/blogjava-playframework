import scala.sys.process.Process

/*
 *  UI Build Hook script
 */

 // execution status success
val Success = 0
val Error = 1

// Roda a tarefa angular serve quando play rodar em modo desenvolvedor isto é quando voce der o comando 'sbt run'
PlayKeys.playRunHooks += baseDirectory.map(FrontendRunHook.apply).value

// Verifica se o sistema é RUINDOWS.
val isWindows = System.getProperty("os.name").toLowerCase().contains("win")

// roda na linha de comando dependendo do sistema operacional usado para executar comandos npm
def runOnCommandline(script: String)(implicit dir: File): Int = {
  if(isWindows){ Process("cmd /c " + script, dir) } else { Process(script, dir) } }!

// verificando se existe a pasta node_modules
def isNodeModulesInstalled(implicit dir: File):Boolean = (dir/"node_modules").exists()

// execute 'npm install' para instalar todas as dependencias de modulos do node. Retorna Sucess se já tiver instalado
def runNpmInstall(implicit dir: File): Int = 
	if(isNodeModulesInstalled) Success else runOnCommandline(FrontendCommands.dependencyInstall)
		

// Execute task if node modules are installed, else return Error status.
def ifNodeModulesInstalled(task: => Int)(implicit dir: File): Int =
  if (runNpmInstall == Success) task
  else Error

// Execute frontend test task. Update to change the frontend test task.
def executeUiTests(implicit dir: File): Int = ifNodeModulesInstalled(runOnCommandline(FrontendCommands.test))

// Execute frontend prod build task. Update to change the frontend prod build task.
def executeProdBuild(implicit dir: File): Int = ifNodeModulesInstalled(runOnCommandline(FrontendCommands.build))
