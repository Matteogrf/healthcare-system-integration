<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:tns="http://events.laboratory.unitn.it/">
  
<xsl:template match="/">
   <tns:EventNotificationResponse xmlns:ns2="http://events.laboratory.unitn.it"> 
     <xsl:value-of select="ns2:SendMappedChangesResponse/out"/>
   </tns:EventNotificationResponse> 
</xsl:template>
    
</xsl:stylesheet>