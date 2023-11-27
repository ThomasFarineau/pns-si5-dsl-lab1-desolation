#!/bin/bash

# Définition des options d'argument
clear_files=false
specific_scenario=""

# Traitement des options d'argument
while getopts ":cs:" opt; do
  case $opt in
    c)
      clear_files=true
      ;;
    s)
      specific_scenario=$OPTARG
      ;;
    \?)
      echo "Option invalide: -$OPTARG" >&2
      exit 1
      ;;
    :)
      echo "L'option -$OPTARG requiert un argument." >&2
      exit 1
      ;;
  esac
done

# Fonction pour compiler un scénario
compile_scenario() {
    file=$1
    filename=$(basename "$file" .arduinoml)

    # Se déplacer vers le répertoire du DSL externe avec AntLR
    cd ../../externals/antlr
    # Nettoyer et construire le package
    mvn clean package

    mvn exec:java -Dexec.args="$file" | grep -v -e "[INFO]" -e "^Using input file:" > ../scenarios/"${filename}_temp.txt"
    tail -n +3 ../scenarios/"${filename}_temp.txt" > ../scenarios/"${filename}.ino"
    rm ../scenarios/"${filename}_temp.txt"
    cd - > /dev/null
}

# Nettoyer les fichiers de sortie si l'option -c est présente
if $clear_files ; then
    rm -f ./externals/scenarios/*.ino
    exit 0
fi

# Naviguer vers le répertoire du noyau JVM
cd ./kernels/jvm
# Nettoyer et installer les dépendances
mvn clean install

# Créer le répertoire 'scenarios' s'il n'existe pas
mkdir -p ../../externals/scenarios

# Compiler soit un scénario spécifique, soit tous les scénarios
if [ -n "$specific_scenario" ]; then
    compile_scenario "src/main/resources/$specific_scenario.arduinoml"
else
    for file in ../../externals/antlr/src/main/resources/*.arduinoml; do
        compile_scenario "$file"
    done
fi

mvn clean
cd ../../kernels/jvm
mvn clean