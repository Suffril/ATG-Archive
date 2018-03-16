if [ ! -d "formatter" ]; then
	echo "Formatter not found, downloading..."
	wget http://download2194.mediafire.com/bim6zi6ra0ng/gi52dtm66ib1952/atg-formatter.tar.gz -nv || { echo 'Download failed :(' ; exit 1; }
	echo "Download successful :)"
	echo "Extracting..."
	tar xf atg-formatter.tar.gz || { echo 'Extraction failed :(' ; exit 1; }
	echo "Extraction complete, cleaning up"
	rm atg-formatter.tar.gz || { echo 'Something broke really badly' ; exit 1; }
fi

java -jar formatter/plugins/org.eclipse.osgi_3.11.2.v20161107-1947.jar -application org.eclipse.jdt.core.JavaCodeFormatter -config formatter/format-settings.ini src/*
rm -r workspace
