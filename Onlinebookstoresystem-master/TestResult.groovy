import hudson.model.*
def matcher = manager.getLogMatcher("(.*)% Tests Passed\$")
 
if (matcher?.matches()) {
 testinfo=matcher.group(1) + "% Tests Passed"
  
 manager.build.addAction(
 new ParametersAction([
 new StringParameterValue("TEST_INFO", testinfo)
 ]))
  
 manager.addShortText(testinfo) 
 
 def intValue = matcher.group(1) as int
 if(intValue>95){
 manager.listener.logger.println("More than 95% test method passed.Build is marked as pass")
 manager.buildSuccess()
 manager.addBadge("green.gif",testinfo)
 }
 else if(intValue>90 && intValue<=95){
 manager.listener.logger.println("Between 90 to 95% test method passed.Build is marked as unstable")
 manager.buildUnstable()
 manager.addBadge("yellow.gif",testinfo)
 }
 else{
 manager.listener.logger.println("Less than 90% test method passed.Build is marked as fail")
 manager.buildFailure()
 manager.addBadge("red.gif",testinfo)
 }
}
else{ 
 manager.listener.logger.println("Overall Build is marked as fail")
 manager.buildFailure()
 manager.addBadge("red.gif",testinfo)
}
