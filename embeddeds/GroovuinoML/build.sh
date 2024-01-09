#!/bin/sh

cd ../../kernels/jvm || exit

# Nettoyer et installer les dépendances
mvn clean install

# Naviguer vers le répertoire du DSL intern
cd ../../embeddeds/GroovuinoML || exit

mvn clean compile assembly:single

# Fonction pour compiler un scénario
compile_scenario() {
    file=$1
    filename=$(basename "$file" .groovy)

    java -jar target/dsl-groovy-1.0-jar-with-dependencies.jar "$file" > result/"$filename".ino

}

for file in ./scripts/*.groovy; do
    compile_scenario "$file"
done