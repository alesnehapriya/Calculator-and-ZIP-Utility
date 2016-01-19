# Calculator-and-ZIP-Utility
Use Case: Calculator and ZIP utility
Primary Actor: End User who wishes to use the Calculator and stores the computation in a File, which can be Zipped, Unzipped, GZip, GUnzip, Select default directory.
Stakeholders and Interest:
End User: who desires to use the Calculator along with ZIP Utility.
Programmer: executes without any errors and fully functional.
Preconditions:
1. Default calculator is shown, but can be selected –Programmer, Scientific and Standard as per the usage.
2. The computations can be stored in a text file which can be zipped, unzip, Gzip,Gunzip.
Success Guarantee – Post Conditions:
The Calculator computes different types of calculation and stores in a history file. History is automatically cleared when the application is closed. Some functions such as M+, MR, MC, M- is used for memory functions.
Main Success Scenario (Basic Flow): Input Events from Actor: End User System Events and Responses
Open the application.
Displays all types of function is one user interface.
User can select specific function from Function Menu
Displays the user interface as per the selection.
Clicks History
Displays the history of all the computations performed.
Clicks “Set Default Directory”
Directory is set as default.
Clicks “Save in File”
History is saved in Test file and result is shown.
Clicks “Upload File”
File can be uploaded and result is shown.
Clicks “ZIP File”
History file is zipped and result is shown.
Clicks “GZip File”
History file is Gzipped and result is shown.
Clicks “Unzip File”
Uploaded file can be unzipped and result is shown.
Clicks “UNGzip File”
Uploaded file can be ungipped and result is shown.
Extensions or Alternative Scenario:
1. Error Message is generated for the following exceptions:
a. If incorrect File is uploaded.
b. If no file is selected.
