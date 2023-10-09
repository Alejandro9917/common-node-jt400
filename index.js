var CallStoreProcedure = require("./lib/CallStoreProdcedure");

async function main(){    
    console.log("Start");
    console.log(CallStoreProcedure.getStoreProcedure());
}

main();