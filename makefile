P=Principal
MAIN_CLASS=aplicacion.$(P)
SRC_DIR=src
OUT_DIR=bin
LIB_DIR=lib
DOC_DIR=html
CLASSPATH=$(LIB_DIR)
JAR_FILE = $(P).jar
compilar:limpiar
	mkdir $(OUT_DIR)
	find $(SRC_DIR) -name *.java | xargs javac -cp $(OUT_DIR) -classpath $(CLASSPATH) -d $(OUT_DIR)

jar:compilar
	@echo "Manifest-Version: 1.0" > manifest.txt
	@echo "Main-Class: $(MAIN_CLASS)" >> manifest.txt
	@echo "Class-Path: $(CLASSPATH)">> manifest.txt
	@echo "" >> manifest.txt	
	jar cfm $(JAR_FILE) manifest.txt  -C $(LIB_DIR) . -C  $(OUT_DIR) . 
ejecutar:compilar
	java -cp "$(OUT_DIR):$(CLASSPATH)" $(MAIN_CLASS)
limpiar:
	rm -rf $(OUT_DIR)
	rm -rf $(DOC_DIR)
	rm -f $(JAR_FILE)
javadoc:compilar
	find . -type f -name "*.java" | xargs javadoc  -cp $(OUT_DIR) -classpath $(CLASSPATH) -d $(DOC_DIR) -encoding utf-8 -docencoding utf-8 -charset utf-8
debug: compilar

	find $(SRC_DIR) -name "*.java" | xargs javac -g -cp $(OUT_DIR) -classpath $(CLASSPATH) -d $(OUT_DIR)
	cd bin; jdb -sourcepath ../src
	cd ..
runjar: jar
	java -jar $(JAR_FILE) 
