#!/bin/bash

# Naviguer vers le répertoire du noyau JVM
cd ./kernels/jvm
# Nettoyer et installer les dépendances
mvn clean install

# Se déplacer vers le répertoire du DSL externe avec AntLR
cd ../../externals/antlr
# Nettoyer et construire le package
mvn clean package

# Créer le répertoire 'scenarios' s'il n'existe pas
mkdir -p ../scenarios

# Exécuter le DSL pour le scénario 'Very Simple Alarm'
mvn exec:java -Dexec.args="src/main/resources/very_simple_alarm.arduinoml" > ../scenarios/very_simple_alarm_output.txt

# Exécuter le DSL pour le scénario 'Dual Check Alarm'
mvn exec:java -Dexec.args="src/main/resources/dual_check_alarm.arduinoml" > ../scenarios/dual_check_alarm_output.txt

# Exécuter le DSL pour le scénario 'Multi State Alarm'
mvn exec:java -Dexec.args="src/main/resources/multi_state_alarm.arduinoml" > ../scenarios/multi_state_alarm_output.txt

# Exécuter le DSL pour le scénario 'State Based Alarm'
mvn exec:java -Dexec.args="src/main/resources/state_based_alarm.arduinoml" > ../scenarios/state_based_alarm_output.txt

mvn clean

cd ../kernels/jvm

mvn clean