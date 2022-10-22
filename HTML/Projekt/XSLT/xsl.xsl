<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <head>
				<meta charset="UTF-8" />
				<title>Sport i rekreacja</title>
				<meta name="viewport" content="width=device-width, initial-scale=1.0" />
				<link rel="stylesheet" href="index.css" />
	</head>
  <body>
    <div id="wrapper">
			<header>
				<h1>Sports</h1>
			</header>
      <xsl:call-template name="nav"/>

      <div id="content">

        <xsl:apply-templates select="project/information"/>

        <xsl:apply-templates select="project/media/image"/>

        <h3 id="links">Additional information about some sports</h3>
						<ul>
							<xsl:apply-templates select="project/links"/>
						</ul>

      	<xsl:apply-templates select="project/facts"/>
        
      
      </div>
    </div>

    <footer>
			<xsl:apply-templates select="project/author"/> 
		</footer>
    
  </body>
  </html>
</xsl:template>

	<xsl:template match="author">
    <xsl:if test="@lang= 'PL'">
		  Copyright 2021, <xsl:value-of select="name"/><xsl:text> </xsl:text><xsl:value-of select="surname"/>
    </xsl:if>
  </xsl:template>

  <xsl:template match="information">
		<h3 id="disciplines">Disciplines</h3>
			<p>
				Information about the disciplines.
			</p>
      <xsl:apply-templates select="disciplines"/>
	</xsl:template>

  <xsl:template match="disciplines">
			<ol>
				<xsl:for-each select="discipline">
					<xsl:choose>
			      <xsl:when test="@category='zespolowe'">
              <li><xsl:value-of select="content"/></li>
					    <ul>
								<li><xsl:value-of select="explication"/></li>
					    </ul>
            </xsl:when>

            <xsl:when test="@category='indywidualne'">
              <li><xsl:value-of select="content"/></li>
				    	<ul>
								<li><xsl:value-of select="explication"/></li>
					    </ul>
            </xsl:when>
          </xsl:choose>
			  </xsl:for-each>
			</ol>
	</xsl:template>

<xsl:template name="nav">
		<nav>
			<ul>
				<li> <a href="#discipline">Disciplines</a> </li>
				<li> <a href="#photos">Photos</a> 	</li>
				<li> <a href="#health">Health</a> </li>
				<li> <a href="#links">Links</a> 		</li>
			</ul>
		</nav>	
</xsl:template>

<xsl:template match="media/image">
		<img>
			<xsl:attribute name="src">
				<xsl:value-of select="@source"/>
			</xsl:attribute>
			<xsl:attribute name="class">
				center
			</xsl:attribute>
			<xsl:attribute name="title">
				<xsl:value-of select="."/>
			</xsl:attribute>
		</img>
	</xsl:template>

  <xsl:template match="links">
			<xsl:apply-templates select="link"/>
	</xsl:template>

  <xsl:template match="link">
			<li>
				<a>
					<xsl:attribute name="href">
						<xsl:value-of select="@source"/>
					</xsl:attribute>
					<xsl:value-of select="."/>
				</a>
			</li>
	</xsl:template>

  <xsl:template match="facts">
    <xsl:if test="@about= 'Sport'">
		  <h3 id="health">Zdrowie i sport</h3>
		  <p>
			  <xsl:value-of select="subtitle"/>
		  </p>
		  <table style="width:50%; border: 5px solid red">
		  	<tr>
			  	<th>Question</th>
			  	<th>Answer</th>
		  	</tr>
			  <tr>
			    <td><xsl:value-of select="title"/></td>
			    <td><xsl:value-of select="text"/></td>
		  </tr>
		  </table>
    </xsl:if>
	</xsl:template>




</xsl:stylesheet>
