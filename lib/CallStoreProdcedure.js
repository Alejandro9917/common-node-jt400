var java = require("java");

java.options.push('-Xrs') // fixing the signal handling issues (for exmaple ctrl-c)
java.options.push('-Dcom.ibm.as400.access.AS400.guiAvailable=false') // Removes gui prompts

java.classpath.push(__dirname + '/../java/lib/common-jt400.jar')
java.classpath.push(__dirname + '/../java/lib/jt400.jar')

module.exports.getStoreProcedure = function() {
    const CallStoreProcedure = java.newInstanceSync('common.CallStoreProcedure');
    return CallStoreProcedure.SimpleConnectionSync()
}