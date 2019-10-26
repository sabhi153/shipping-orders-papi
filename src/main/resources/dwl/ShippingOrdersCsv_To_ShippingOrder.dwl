%dw 2.0
output application/json
var columnName = 'shipmentNumber'
import capitalize from dw::core::Strings
fun getRecordValue(columnNo :Number , csvRecord :Array) = csvRecord[columnNo]
fun translateCSVRecord (csvRecord :Array,csvFormat) = 
do {
		var headerString = csvFormat.header[0]
var headers =  headerString splitBy(",")
var headerIndexes = headers map
((item, index) -> index )
---
headerIndexes reduce((item, acc = {
}) -> acc ++ 
			{
	(headers[item]):getRecordValue(item,csvRecord)
})
		
		
	}
---
(vars.csvReaderParserMap.parser as Iterator map((csvRecord, index) -> translateCSVRecord(csvRecord,vars.csvFormat) )) 