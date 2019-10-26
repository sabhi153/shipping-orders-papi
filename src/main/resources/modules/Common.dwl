%dw 2.0
var fileTimeFormat = "yyyy-MM-dd HH:mm:ss"

fun deriveTargetFileName( status :Boolean , origFileName :String) = if (status) (origFileName ++ (now() as String {format: fileTimeFormat}) ++ ".success ") else (origFileName ++ (now() as String {format: fileTimeFormat}) ++ ".error ")
fun getRecordValue(columnName :String , csvRecord :Array) = log('LEVEL INDEX - ',csvRecord["'" ++ columnName ++ "'"])
fun translateCSVRecord (csvRecord :Array,csvFormat) = 


	do {
		var headerString = csvFormat.header[0]
var headers =  headerString splitBy(",")
---
headers reduce((item, acc = {
}) -> acc ++ {
	(item):getRecordValue(item,csvRecord)
})
		
		
	}
	


