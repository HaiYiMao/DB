<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<ol>
					<xsl:for-each select="siteList/site/tower/equipment">
						<li>
							<xsl:value-of select="@name" />
							<xsl:text>, brand: </xsl:text>
							<xsl:value-of select="@brand" />
							<xsl:text>, description: </xsl:text>
							<xsl:value-of select="@description" />
							<xsl:text>, price: </xsl:text>
							<xsl:value-of select="@price" />
							<xsl:text>, tower: </xsl:text>
							<xsl:value-of select="../@name" />
							<xsl:text>, site: </xsl:text>
							<xsl:value-of select="../../@name" />
						</li>
					</xsl:for-each>
				</ol>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>