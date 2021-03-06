<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<ol>
					<xsl:for-each select="siteList/site">
						<li>
							<xsl:value-of select="@name" />
							<xsl:text>, latitude: </xsl:text>
							<xsl:value-of select="@latitude" />
							<xsl:text>, longitude: </xsl:text>
							<xsl:value-of select="@longitude" />
							<ul>
								<xsl:for-each select="tower">
									<li>
										<xsl:value-of select="@name" />
										<xsl:text>, height: </xsl:text>
										<xsl:value-of select="@height" />
										<xsl:text>, sides: </xsl:text>
										<xsl:value-of select="@sides" />
									</li>
								</xsl:for-each>
							</ul>
						</li>
					</xsl:for-each>
				</ol>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>