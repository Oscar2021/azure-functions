package com.syamti.azure;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.OutputBinding;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.BlobTrigger;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.sql.annotation.CommandType;
import com.microsoft.azure.functions.sql.annotation.SQLInput;

import com.microsoft.azure.functions.sql.annotation.SQLOutput;
import com.syamti.azure.entity.DevTest;

public class BlobStorageTriggerFunction {

    @FunctionName("BlobProcessor")
    public void run(
            @BlobTrigger(
                    name = "file",
                    dataType = "binary",
                    path = "devcontainer/{name}",
                    connection = "MyBlobStorage"
            ) byte[] fileContent,
            @BindingName("name") String filename,
//            @SQLInput(
//                    name = "devtestget",
//                    commandText = "SELECT * FROM devtest t WHERE id = 1",
//                    commandType = CommandType.Text,
////                    parameters = "@Id={id}",
//                    connectionStringSetting = "RemoteSQLConnStr"
//            ) DevTest[] devTestInput,
//            @SQLOutput(
//                    name = "devtestaddorupdate",
//                    commandText = "devtest",
//                    connectionStringSetting = "RemoteSQLConnStr"
//            ) OutputBinding<DevTest[]> devTestOutput,
            final ExecutionContext context
            ) {

//        var product = devTestInput[0];
//        System.out.println("Product: " + product.getName());
//        product.setQty(product.getQty() + 1);
//        devTestOutput.setValue(new DevTest[]{product});

        context.getLogger().info("Name: " + filename + " Size: " + fileContent.length + " bytes");
    }

}
