#
# ADOBE CONFIDENTIAL
# ___________________
#
# Copyright 2017 Adobe Systems Incorporated
# All Rights Reserved.
#
# NOTICE:  All information contained herein is, and remains
# the property of Adobe Systems Incorporated and its suppliers,
# if any.  The intellectual and technical concepts contained
# herein are proprietary to Adobe Systems Incorporated and its
# suppliers and are protected by trade secret or copyright law.
# Dissemination of this information or reproduction of this material
# is strictly forbidden unless prior written permission is obtained
# from Adobe Systems Incorporated.
#

source ~/.bash_profile
echo ""
echo "================================================="
echo " Build and deploy event-model on local AEM server"
echo "================================================="
mvn -f pom-bundle.xml -P localInstall clean install sling:install

# to do it against cloud-action-dev.corp
###########################################
# mvn -f pom-bundle.xml -P localInstall  -Dcrx.host=cloud-action-dev.corp.adobe.com clean install sling:install

# to do it against adobesummit.adobesandbox.com
###########################################
# mvn -f pom-bundle.xml -P localInstall  -Dcrx.host=adobesummit.adobesandbox.com -Dcrx.password=Swaq68#Ap@st clean install sling:install

