#Debug CA Cert

Notes to debug ca cert issue where Java is failing to verify certificate chain.  

The new ca cert is missing intermediate CA to "AddTrust External CA Root" which is one of the entry in the default Java TrustStore.

Compare the two outputs for:

	apps-stable.ingenuity.com current.txt
	apps-stable2.ingenuity.com new.txt

Debug options:

	-Djavax.net.debug=ssl:handshake


#Links

	http://docs.oracle.com/javase/7/docs/technotes/guides/security/jsse/ReadDebug.html
	
	http://docs.oracle.com/javase/7/docs/technotes/guides/security/jsse/JSSERefGuide.html#SSLOverview

#Enable debug

-Djavax.net.debug=all
-Djavax.net.debug=ssl:handshake

#Disable check

-Dcom.sun.net.ssl.checkRevocation=false