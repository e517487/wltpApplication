# WLTP #

This java project WLTP is a Proof of Concept to get the CO2 values for a certain car and his options from a PSA webservice.

## Webservice description ##

This wsdl contains the definition of the ConfigV2 webservice, which contains the WLTP info.
- Config.wsdl
- Select.wsdl
- there are more but we don't need these.

The Config.wsdl is the one which we need to use to get the WLTP information for the CO2 values and total.


### Url to use for Config: ### 
PREPROD
https://preprod.api.inetpsa.com/applications/moteur-de-configuration-vn/config/v1?client_id=bd896111-cf8f-4c55-9cc3-eda7fdba06b8

PROD
https://api.inetpsa.com/applications/moteur-de-configuration-vn/config/v1?client_id=748c557e-eb73-4434-b7a8-6e1e704abd14
urls no authorisation

### Url to use for select: ###
PREPROD
https://preprod.api.inetpsa.com/applications/moteur-de-configuration-vn/select/v1?client_id=bd896111-cf8f-4c55-9cc3-eda7fdba06b8

PROD
https://api.inetpsa.com/applications/moteur-de-configuration-vn/select/v1?client_id=748c557e-eb73-4434-b7a8-6e1e704abd14
urls no authorisation
### Gathered information ###

- what country/brand is this for?     
    - Netherlands & Peugeot Citroen DS:
        - APNL
        - ACNL


### Contacts for support  ####

GERMAN DIAZ SANCHEZ - E516816 : german.diaz@ext.mpsa.com








This document has the basic specifications of the necessary message structure to build a xml, however it's not updated with the WLTP info.

Here's a WLTP request sample, it's important you fill the fields highlighted in red with valid information:

````
<soapenv:Envelope 
       xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
       xmlns:xsd="http://www.w3.org/2001/XMLSchema" 
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
   <soapenv:Body>
      <ConfigV2 xmlns="http://xml.inetpsa.com/Services/Cfg/Config">
         <ns1:Config xmlns:ns1="http://inetpsa.com/cfg">
            <ns1:ContextRequest>
               <ns1:Client>websimulator</ns1:Client>
               <ns1:Brand>P</ns1:Brand>
               <ns1:Country>NL</ns1:Country>
               <ns1:Date>2018-08-08</ns1:Date>
               <ns1:LanguageID>NL</ns1:LanguageID>
               <ns1:TaxIncluded>true</ns1:TaxIncluded>
               <ns1:LocalCurrency>false</ns1:LocalCurrency>
            </ns1:ContextRequest>
            <ns1:ConfigCriteria>
               <ns1:Version>1PT9A5TLHKB0A0D0</ns1:Version>
               <ns1:WLTP>
                  <ns1:FlagWLTP>true</ns1:FlagWLTP>
                  <ns1:PhaseWLTP>FULL</ns1:PhaseWLTP>
               </ns1:WLTP>
               <ns1:Feature>
                  <ns1:id>0P8D0RFJ</ns1:id>
               </ns1:Feature>
               <ns1:Feature>
                  <ns1:id>0MM60NN9</ns1:id>
               </ns1:Feature>
            </ns1:ConfigCriteria>
         </ns1:Config>
      </ConfigV2>
   </soapenv:Body>
</soapenv:Envelope>
````

Answer:
````
<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <ns1:ConfigV2Response xmlns:ns1="http://xml.inetpsa.com/Services/Cfg/Config">
         <ConfigResponseV2 xmlns="http://inetpsa.com/cfg">
            <Version>
               <IdVersion>
                  <id>1PT9A5TLHKB0A0D0</id>
                  <label>308 GT Line 1.2 PureTech 130</label>
               </IdVersion>
               <VehicleUse>
                  <id>VP</id>
                  <label>Personenauto</label>
               </VehicleUse>
               <Model>
                  <id>1PT9</id>
                  <label>308</label>
               </Model>
               <VehiclePrice>
                  <basePrice>35180.00</basePrice>
                  <netPrice>35180.00</netPrice>
                  <discount>0.00</discount>
                  <priceStartDate>2018-05-01</priceStartDate>
                  <priceEndDate>2243-10-17</priceEndDate>
               </VehiclePrice>
               <Price>
                  <basePrice>32060.00</basePrice>
                  <netPrice>32060.00</netPrice>
                  <discount>0.00</discount>
                  <priceStartDate>2018-05-01</priceStartDate>
                  <priceEndDate>2243-10-17</priceEndDate>
               </Price>
               <FeaturesPrice>
                  <basePrice>3120.00</basePrice>
                  <netPrice>3120.00</netPrice>
                  <discount>0.00</discount>
               </FeaturesPrice>
               <OptionalFeaturesPrice>
                  <basePrice>0.00</basePrice>
                  <netPrice>0.00</netPrice>
                  <discount>0.00</discount>
               </OptionalFeaturesPrice>
               <LookFeaturesPrice>
                  <basePrice>3120.00</basePrice>
                  <netPrice>3120.00</netPrice>
                  <discount>0.00</discount>
               </LookFeaturesPrice>
               <Grade>
                  <id>T</id>
                  <label>GT-line</label>
               </Grade>
               <BodyStyle>
                  <id>A5</id>
                  <label>Berline</label>
               </BodyStyle>
               <GrbodyStyle>
                  <id>00000BER</id>
                  <label>Berline</label>
               </GrbodyStyle>
               <DesignClass>
                  <id>B0</id>
                  <label>B0</label>
               </DesignClass>
               <CustomerType>
                  <id>A0</id>
                  <label>A0</label>
               </CustomerType>
               <ModelYear>
                  <id>D</id>
                  <label>D</label>
               </ModelYear>
               <ModelYearModification>
                  <id>0</id>
                  <label>0</label>
               </ModelYearModification>
               <GrCommercialName>
                  <id>GT-LINE0</id>
                  <label>GT-line</label>
               </GrCommercialName>
               <Engine>
                  <id>LH</id>
                  <label>1.2 PureTech 130 E6.2</label>
               </Engine>
               <GrEngine>
                  <id>E6PTH130</id>
                  <label>PureTech 130 S&amp;S</label>
               </GrEngine>
               <TransmissionType>
                  <id>K</id>
                  <label>6-bak Handgeschakeld</label>
               </TransmissionType>
               <GrTransmissionType>
                  <id>000000H6</id>
                  <label>6-bak Handgeschakeld</label>
               </GrTransmissionType>
               <Energy>
                  <id>02</id>
                  <label>Benzine</label>
               </Energy>
               <Co2Rate>120.0</Co2Rate>
               <Co2Class>C</Co2Class>
               <EcoLabel>false</EcoLabel>
               <MixedConsumption>5.2</MixedConsumption>
               <MixedConsumptionComplex>
                  <decimalValue>5.2</decimalValue>
                  <stringValue>5,2</stringValue>
               </MixedConsumptionComplex>
               <ExteriorLength>4.253</ExteriorLength>
               <ExteriorLengthComplex>
                  <decimalValue>4.253</decimalValue>
                  <stringValue>4,253</stringValue>
               </ExteriorLengthComplex>
               <ExteriorHeight>1.457</ExteriorHeight>
               <ExteriorHeightComplex>
                  <decimalValue>1.457</decimalValue>
                  <stringValue>1,457</stringValue>
               </ExteriorHeightComplex>
               <TrunkVolume>210.0</TrunkVolume>
               <TrunkVolumeComplex>
                  <decimalValue>210.0</decimalValue>
                  <stringValue>210</stringValue>
               </TrunkVolumeComplex>
               <NumSittedPlaces>5</NumSittedPlaces>
               <NumSittedPlacesComplex>
                  <decimalValue>5.0</decimalValue>
                  <stringValue>5</stringValue>
               </NumSittedPlacesComplex>
               <Characteristic1>96</Characteristic1>
               <ExtendedCode>1PT9A5TLHKB0A0D0 M6N98DFJ OK01 ZV47 WLF5 QK02 YR07</ExtendedCode>
               <VisualCode>1PT9A5TLHKB0A0D0 0MM60NN9 0P8D0RFJ OK01 ZV47 WLF5 QK02 YR07</VisualCode>
               <StandardFeatures>
                  <Category>
                     <id>0003</id>
                     <label>Veiligheid</label>
                     <rank>3</rank>
                     <StandardFeatures>
                        <id>EK08</id>
                        <code>EK#2#EK08</code>
                        <label>LED dagrijverlichting geïntegreerd in de koplampen</label>
                        <rank>10526</rank>
                        <classe>EK</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>NF04</id>
                        <code>NF#2#NF04</code>
                        <label>Adaptieve airbags, zij-airbags voor, windowairbags</label>
                        <rank>10838</rank>
                        <classe>NF</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>UE02</id>
                        <code>UE#2#UE02</code>
                        <label>Bandenspanningscontrolesysteem</label>
                        <rank>11180</rank>
                        <classe>UE</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>UF01</id>
                        <code>UF#2#UF01</code>
                        <label>ESP (Elektronisch Stabiliteits Programma)</label>
                        <rank>11191</rank>
                        <classe>UF</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>YR07</id>
                        <code>YR#5#YR07</code>
                        <label>Peugeot Connect SOS</label>
                        <rank>11590</rank>
                        <classe>YR</classe>
                        <assembly>5</assembly>
                     </StandardFeatures>
                  </Category>
                  <Category>
                     <id>0004</id>
                     <label>Comfort</label>
                     <rank>4</rank>
                     <StandardFeatures>
                        <id>AU02</id>
                        <code>AU#2#AU02</code>
                        <label>Middenarmsteun achter met skiluik</label>
                        <rank>10340</rank>
                        <classe>AU</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>FH05</id>
                        <code>FH#2#FH05</code>
                        <label>Elektrische parkeerrem</label>
                        <rank>10572</rank>
                        <classe>FH</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>HU13</id>
                        <code>HU#2#HU13</code>
                        <label>Elektrisch inklapbare buitenspiegels</label>
                        <rank>10632</rank>
                        <classe>HU</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>JA11</id>
                        <code>JA#2#JA11</code>
                        <label>Centrale vergrendeling met afstandsbediening</label>
                        <rank>10690</rank>
                        <classe>JA</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>JB04</id>
                        <code>JB#2#JB04</code>
                        <label>Middenarmsteun voor</label>
                        <rank>10696</rank>
                        <classe>JB</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>LE05</id>
                        <code>LE#2#LE05</code>
                        <label>Elektrisch bedienbare achterportierruiten</label>
                        <rank>10746</rank>
                        <classe>LE</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>QK02</id>
                        <code>QK#5#QK02</code>
                        <label>Achteruitrijcamera 180° Visiopark 1</label>
                        <rank>10962</rank>
                        <classe>QK</classe>
                        <assembly>5</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>RE07</id>
                        <code>RE#2#RE07</code>
                        <label>Climate control links-rechts gescheiden regelbaar</label>
                        <rank>11043</rank>
                        <classe>RE</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>RG03</id>
                        <code>RG#2#RG03</code>
                        <label>Cruise control met instelbare snelheidsbegrenzer</label>
                        <rank>11054</rank>
                        <classe>RG</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>RL05</id>
                        <code>RL#2#RL05</code>
                        <label>Automatisch dimmende binnenspiegel</label>
                        <rank>11086</rank>
                        <classe>RL</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>UB03</id>
                        <code>UB#2#UB03</code>
                        <label>Parkeerhulp voor</label>
                        <rank>11154</rank>
                        <classe>UB</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>VB09</id>
                        <code>VB#2#VB09</code>
                        <label>Centrale vergrendeling met afstandsbediening</label>
                        <rank>11232</rank>
                        <classe>VB</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>VH05</id>
                        <code>VH#2#VH05</code>
                        <label>Lederen sportstuur met GT-logo</label>
                        <rank>11303</rank>
                        <classe>VH</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>WA88</id>
                        <code>WA#2#WA88</code>
                        <label>Elektrisch verstelbare bestuurdersstoel</label>
                        <rank>11316</rank>
                        <classe>WA</classe>
                        <description>Inclusief geheugen voor 2 posities, verwarmbare voorstoelen met massagefunctie, elektrische lendensteunverstelling op beide voorstoelen. Alleen i.c.m. lederen bekleding.</description>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>YQ01</id>
                        <code>YQ#2#YQ01</code>
                        <label>Automatische verlichting</label>
                        <rank>11570</rank>
                        <classe>YQ</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                  </Category>
                  <Category>
                     <id>0005</id>
                     <label>Interieur</label>
                     <rank>5</rank>
                     <StandardFeatures>
                        <id>EE22</id>
                        <code>EE#2#EE22</code>
                        <label>RVS instaplijsten voorportieren</label>
                        <rank>10517</rank>
                        <classe>EE</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>ES04</id>
                        <code>ES#2#ES04</code>
                        <label>12V-aansluiting in de kofferruimte</label>
                        <rank>10551</rank>
                        <classe>ES</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>GM62</id>
                        <code>GM#2#GM62</code>
                        <label>Kleurendisplay in het instrumentenpaneel</label>
                        <rank>10598</rank>
                        <classe>GM</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>SD34</id>
                        <code>SD#2#SD34</code>
                        <label>Interieur afgewerkt met rode stiksels</label>
                        <rank>11117</rank>
                        <classe>SD</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>YE02</id>
                        <code>YE#2#YE02</code>
                        <label>Aluminium pedalen</label>
                        <rank>11546</rank>
                        <classe>YE</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                  </Category>
                  <Category>
                     <id>0006</id>
                     <label>Exterieur</label>
                     <rank>6</rank>
                     <StandardFeatures>
                        <id>GV04</id>
                        <code>GV#2#GV04</code>
                        <label>Chroomomlijsting van de zijruiten</label>
                        <rank>10604</rank>
                        <classe>GV</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>LA05</id>
                        <code>LA#2#LA05</code>
                        <label>Pack Full LED</label>
                        <rank>10739</rank>
                        <classe>LA</classe>
                        <description>Full LED koplampen met automatische hoogteregeling, LED-mistlampen, LED-richtingaanwijzers met 'dynamic scrolling'. Inclusief sportbumper op Allure.</description>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>MPEE</id>
                        <code>MP#2#MPEE</code>
                        <label>Badges GT-line</label>
                        <rank>10790</rank>
                        <classe>MP</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>OK01</id>
                        <code>OK#5#OK01</code>
                        <label>Glazen panoramadak</label>
                        <rank>10865</rank>
                        <classe>OK</classe>
                        <description>Inclusief extra getinte achterruit.</description>
                        <assembly>5</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>PD41</id>
                        <code>PD#2#PD41</code>
                        <label>Grille met verchroomde facetten in dambordpatroon</label>
                        <rank>10901</rank>
                        <classe>PD</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>RZ89</id>
                        <code>RZ#2#RZ89</code>
                        <label>Deurgrepen en buitenspiegels in kleur carrosserie</label>
                        <rank>11110</rank>
                        <classe>RZ</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>VD10</id>
                        <code>VD#2#VD10</code>
                        <label>Extra getinte achterste zijruiten</label>
                        <rank>11262</rank>
                        <classe>VD</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>YI45</id>
                        <code>YI#2#YI45</code>
                        <label>Glanzend zwarte buitenspiegels</label>
                        <rank>11560</rank>
                        <classe>YI</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                  </Category>
                  <Category>
                     <id>0009</id>
                     <label>Velgen</label>
                     <rank>7</rank>
                     <StandardFeatures>
                        <id>DZJT</id>
                        <code>DZ#2#DZJT</code>
                        <label>17" lichtmetalen velgen 'Rubis'</label>
                        <rank>10493</rank>
                        <classe>DZ</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                  </Category>
                  <Category>
                     <id>0016</id>
                     <label>Packs</label>
                     <rank>9</rank>
                     <StandardFeatures>
                        <id>ZV47</id>
                        <code>ZV#5#ZV47</code>
                        <label>Pack Drive Assist 1</label>
                        <rank>11743</rank>
                        <classe>ZV</classe>
                        <description>Grootlichtassistent, vermoeidheidsherkenning, active lane departure warning system, herkenning van verkeersborden met snelheidsbeperking. Inclusief kleurendisplay in het instrumentenpaneel</description>
                        <assembly>5</assembly>
                     </StandardFeatures>
                  </Category>
                  <Category>
                     <id>0017</id>
                     <label>Audio &amp; Navigatie</label>
                     <rank>10</rank>
                     <StandardFeatures>
                        <id>DO01</id>
                        <code>DO#2#DO01</code>
                        <label>Bluetooth handsfree telefoonverbinding</label>
                        <rank>10454</rank>
                        <classe>DO</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>E201</id>
                        <code>E2#2#E201</code>
                        <label>Apple carplay, Mirrorlink en Android Auto</label>
                        <rank>10506</rank>
                        <classe>E2</classe>
                        <assembly>2</assembly>
                     </StandardFeatures>
                     <StandardFeatures>
                        <id>WLF5</id>
                        <code>WL#5#WLF5</code>
                        <label>Peugeot Connect 3D Nav &amp; DAB+</label>
                        <rank>11400</rank>
                        <classe>WL</classe>
                        <assembly>5</assembly>
                     </StandardFeatures>
                  </Category>
               </StandardFeatures>
               <TechnicalCharacteristics>
                  <Category>
                     <id>0010</id>
                     <label>Afmetingen exterieur</label>
                     <rank>1</rank>
                     <TechnicalCharacteristics>
                        <id>0001</id>
                        <label>Totale lengte (mm)</label>
                        <rank>1</rank>
                        <value>4,253</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0003</id>
                        <label>Totale breedte excl./incl. spiegels (mm)</label>
                        <rank>2</rank>
                        <value>1,804/2,038</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0004</id>
                        <label>Totale hoogte (mm)</label>
                        <rank>4</rank>
                        <value>1,457</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0005</id>
                        <label>Wielbasis (mm)</label>
                        <rank>5</rank>
                        <value>2,620</value>
                     </TechnicalCharacteristics>
                  </Category>
                  <Category>
                     <id>0018</id>
                     <label>Afmetingen interieur</label>
                     <rank>2</rank>
                     <TechnicalCharacteristics>
                        <id>0008</id>
                        <label>Aantal zitplaatsen</label>
                        <rank>12</rank>
                        <value>5</value>
                     </TechnicalCharacteristics>
                  </Category>
                  <Category>
                     <id>0012</id>
                     <label>Gewichten (kg)</label>
                     <rank>3</rank>
                     <TechnicalCharacteristics>
                        <id>0005</id>
                        <label>Leeggewicht</label>
                        <rank>1</rank>
                        <value>1064</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0009</id>
                        <label>Totaal toegestaan belast gewicht</label>
                        <rank>2</rank>
                        <value>1750</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0010</id>
                        <label>Max. toegestaan treingewicht</label>
                        <rank>3</rank>
                        <value>3050</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0006</id>
                        <label>Max. aanhangergewicht geremd</label>
                        <rank>4</rank>
                        <value>1300</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0007</id>
                        <label>Max. aanhangergewicht ongeremd</label>
                        <rank>5</rank>
                        <value>570</value>
                     </TechnicalCharacteristics>
                  </Category>
                  <Category>
                     <id>0001</id>
                     <label>Motor</label>
                     <rank>4</rank>
                     <TechnicalCharacteristics>
                        <id>0008</id>
                        <label>Cilinderinhoud (in cm3)</label>
                        <rank>1</rank>
                        <value>1199</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0010</id>
                        <label>Emissienorm</label>
                        <rank>2</rank>
                        <value>Euro 6.d-TEMP</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0009</id>
                        <label>Aantal cilinders</label>
                        <rank>3</rank>
                        <value>3</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0012</id>
                        <label>Max. vermogen/omw. - norm CEEkW (DINpk)</label>
                        <rank>5</rank>
                        <value>96 (130)/5500</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0013</id>
                        <label>Max. koppel/omw. - norm CEE (Nm)</label>
                        <rank>6</rank>
                        <value>230/1750</value>
                     </TechnicalCharacteristics>
                  </Category>
                  <Category>
                     <id>0005</id>
                     <label>Prestaties</label>
                     <rank>5</rank>
                     <TechnicalCharacteristics>
                        <id>0002</id>
                        <label>Topsnelheid (km/u)</label>
                        <rank>1</rank>
                        <value>210</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0003</id>
                        <label>Acceleratietijd van 0 - 100 km/u (s)</label>
                        <rank>2</rank>
                        <value>9,1</value>
                     </TechnicalCharacteristics>
                  </Category>
                  <Category>
                     <id>0006</id>
                     <label>Verbruik</label>
                     <rank>6</rank>
                     <TechnicalCharacteristics>
                        <id>0003</id>
                        <label>Verbruik binnen de bebouwde kom (l/100km)</label>
                        <rank>1</rank>
                        <value>6,5</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0004</id>
                        <label>Verbruik buiten de bebouwde kom (l/100km)</label>
                        <rank>2</rank>
                        <value>4,5</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0002</id>
                        <label>Gecombineerd verbruik (l/100km)</label>
                        <rank>3</rank>
                        <value>5,2</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0005</id>
                        <label>CO2-uitstoot bij gecombineerd verbruik (g/km)</label>
                        <rank>4</rank>
                        <value>120</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0006</id>
                        <label>Inhoud brandstoftank (l)</label>
                        <rank>5</rank>
                        <value>53</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0007</id>
                        <label>Brandstof</label>
                        <rank>6</rank>
                        <value>Benzine</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0001</id>
                        <label>Gecombineerd verbruik (km/l)</label>
                        <rank>7</rank>
                        <value>19,2</value>
                     </TechnicalCharacteristics>
                  </Category>
                  <Category>
                     <id>0021</id>
                     <label>Versnellingsbak</label>
                     <rank>7</rank>
                     <TechnicalCharacteristics>
                        <id>0001</id>
                        <label>Versnellingsbak</label>
                        <rank>1</rank>
                        <value>Handgeschakeld 6-versnellingen</value>
                     </TechnicalCharacteristics>
                  </Category>
                  <Category>
                     <id>0013</id>
                     <label>Banden</label>
                     <rank>8</rank>
                     <TechnicalCharacteristics>
                        <id>0001</id>
                        <label>Bandenmaat</label>
                        <rank>1</rank>
                        <value>225/45R17V</value>
                     </TechnicalCharacteristics>
                     <TechnicalCharacteristics>
                        <id>0002</id>
                        <label>Reservewiel / Bandenreparatieset</label>
                        <rank>2</rank>
                        <value>Reservewiel type thuiskomer</value>
                     </TechnicalCharacteristics>
                  </Category>
                  <Category>
                     <id>9100</id>
                     <label>indicateurs WLTP</label>
                     <rank>18</rank>
                     <TechnicalCharacteristics>
                        <id>0001</id>
                        <label>famille WLTP</label>
                        <rank>1</rank>
                        <value>1</value>
                     </TechnicalCharacteristics>
                  </Category>
               </TechnicalCharacteristics>
               <OptionalFeatures>
                  <Category>
                     <id>0003</id>
                     <label>Veiligheid</label>
                     <rank>3</rank>
                     <OptionalFeatures>
                        <id>AB08</id>
                        <code>AB#3#AB08</code>
                        <rank>10295</rank>
                        <classe>AB</classe>
                        <label>Alarm met supervergrendeling</label>
                        <Price>
                           <basePrice>400.00</basePrice>
                           <netPrice>400.00</netPrice>
                           <discount>0.00</discount>
                        </Price>
                        <assembly>3</assembly>
                     </OptionalFeatures>
                  </Category>
                  <Category>
                     <id>0004</id>
                     <label>Comfort</label>
                     <rank>4</rank>
                     <OptionalFeatures>
                        <id>YD01</id>
                        <code>YD#3#YD01</code>
                        <rank>11539</rank>
                        <classe>YD</classe>
                        <label>Keyless entry &amp; start</label>
                        <Price>
                           <basePrice>500.00</basePrice>
                           <netPrice>500.00</netPrice>
                           <discount>0.00</discount>
                        </Price>
                        <assembly>3</assembly>
                     </OptionalFeatures>
                  </Category>
                  <Category>
                     <id>0009</id>
                     <label>Velgen</label>
                     <rank>7</rank>
                     <OptionalFeatures>
                        <id>ZH6G</id>
                        <code>ZH#3#ZH6G</code>
                        <rank>11642</rank>
                        <classe>ZH</classe>
                        <label>18" lichtmetalen velgen Diamant - reservewiel</label>
                        <Price>
                           <basePrice>650.00</basePrice>
                           <netPrice>650.00</netPrice>
                           <discount>0.00</discount>
                        </Price>
                        <assembly>3</assembly>
                     </OptionalFeatures>
                     <OptionalFeatures>
                        <id>ZH6P</id>
                        <code>ZH#3#ZH6P</code>
                        <rank>11644</rank>
                        <classe>ZH</classe>
                        <label>18" lichtmetalen velgen Diamant - bij Denon</label>
                        <Price>
                           <basePrice>650.00</basePrice>
                           <netPrice>650.00</netPrice>
                           <discount>0.00</discount>
                        </Price>
                        <assembly>3</assembly>
                     </OptionalFeatures>
                  </Category>
                  <Category>
                     <id>0016</id>
                     <label>Packs</label>
                     <rank>9</rank>
                     <OptionalFeatures>
                        <id>UB08</id>
                        <code>UB#3#UB08</code>
                        <rank>11164</rank>
                        <classe>UB</classe>
                        <label>Pack side security</label>
                        <description>Actieve dodehoekbewaking &amp; actieve parkeerhulp.</description>
                        <Price>
                           <basePrice>400.00</basePrice>
                           <netPrice>400.00</netPrice>
                           <discount>0.00</discount>
                        </Price>
                        <assembly>3</assembly>
                     </OptionalFeatures>
                     <OptionalFeatures>
                        <id>ZV49</id>
                        <code>ZV#3#ZV49</code>
                        <rank>11744</rank>
                        <classe>ZV</classe>
                        <label>Pack Drive Assist 2</label>
                        <description>Adaptieve cruise control, waarschuwing bij kans op aanrijding en automatisch noodremsysteem. Inclusief elektrische parkeerrem en alle items van Pack Drive Assist 1.</description>
                        <Price>
                           <basePrice>600.00</basePrice>
                           <netPrice>600.00</netPrice>
                           <discount>0.00</discount>
                        </Price>
                        <assembly>3</assembly>
                     </OptionalFeatures>
                  </Category>
                  <Category>
                     <id>0017</id>
                     <label>Audio &amp; Navigatie</label>
                     <rank>10</rank>
                     <OptionalFeatures>
                        <id>UN01</id>
                        <code>UN#3#UN01</code>
                        <rank>11215</rank>
                        <classe>UN</classe>
                        <label>Denon Hi-Fi- geluidssysteem</label>
                        <description>Reservewiel type thuiskomer wordt hierbij vervangen door een bandenreparatieset.</description>
                        <Price>
                           <basePrice>650.00</basePrice>
                           <netPrice>650.00</netPrice>
                           <discount>0.00</discount>
                        </Price>
                        <assembly>3</assembly>
                     </OptionalFeatures>
                     <OptionalFeatures>
                        <id>WLF6</id>
                        <code>WL#3#WLF6</code>
                        <rank>11401</rank>
                        <classe>WL</classe>
                        <label>CD speler</label>
                        <Price>
                           <basePrice>150.00</basePrice>
                           <netPrice>150.00</netPrice>
                           <discount>0.00</discount>
                        </Price>
                        <assembly>3</assembly>
                     </OptionalFeatures>
                  </Category>
                  <Category>
                     <id>0021</id>
                     <label>Rijplezier</label>
                     <rank>14</rank>
                     <OptionalFeatures>
                        <id>QM02</id>
                        <code>QM#3#QM02</code>
                        <rank>10967</rank>
                        <classe>QM</classe>
                        <label>Driver Sport Pack</label>
                        <description>Driver Sport Pack houdt in: Sportknop in het interieur voor fellere gasrespons, meer stuurgevoel, sportiever motorgeluid en grafische weergave van rijparameters</description>
                        <Price>
                           <basePrice>500.00</basePrice>
                           <netPrice>500.00</netPrice>
                           <discount>0.00</discount>
                        </Price>
                        <assembly>3</assembly>
                     </OptionalFeatures>
                  </Category>
               </OptionalFeatures>
               <LookFeatures>
                  <InteriorFeatures>
                     <id>0P1U0RFJ</id>
                     <code>0P#0#0P1U0RFJ</code>
                     <rank>242</rank>
                     <classe>0P</classe>
                     <label>Alcantara/kunstleder met rood stiksel</label>
                     <Price>
                        <basePrice>900.00</basePrice>
                        <netPrice>900.00</netPrice>
                        <discount>0.00</discount>
                     </Price>
                     <assembly>0</assembly>
                     <specific>0P1U0RFJ</specific>
                     <isDefault>false</isDefault>
                  </InteriorFeatures>
                  <InteriorFeatures>
                     <id>0P8D0RFJ</id>
                     <code>0P#0#0P8D0RFJ</code>
                     <rank>243</rank>
                     <classe>0P</classe>
                     <label>Lederen bekleding zwart met rood stiksel</label>
                     <Price>
                        <basePrice>2200.00</basePrice>
                        <netPrice>2200.00</netPrice>
                        <discount>0.00</discount>
                     </Price>
                     <assembly>0</assembly>
                     <selection>user</selection>
                     <specific>0P8D0RFJ</specific>
                     <isDefault>false</isDefault>
                  </InteriorFeatures>
                  <InteriorFeatures>
                     <id>0P0N0RFJ</id>
                     <code>0P#0#0P0N0RFJ</code>
                     <rank>992</rank>
                     <classe>0P</classe>
                     <label>kunstleder / stof  OXFORD rouge</label>
                     <Price>
                        <basePrice>0.00</basePrice>
                        <netPrice>0.00</netPrice>
                        <discount>0.00</discount>
                     </Price>
                     <assembly>0</assembly>
                     <specific>0P0N0RFJ</specific>
                     <isDefault>false</isDefault>
                  </InteriorFeatures>
                  <ExteriorFeatures>
                     <id>0MM00N9V</id>
                     <code>0M#1#0MM00N9V</code>
                     <rank>3</rank>
                     <classe>0M</classe>
                     <label>Noir Perla Nera</label>
                     <Price>
                        <basePrice>720.00</basePrice>
                        <netPrice>720.00</netPrice>
                        <discount>0.00</discount>
                     </Price>
                     <assembly>1</assembly>
                     <isDefault>true</isDefault>
                  </ExteriorFeatures>
                  <ExteriorFeatures>
                     <id>0MM00NF4</id>
                     <code>0M#1#0MM00NF4</code>
                     <rank>4</rank>
                     <classe>0M</classe>
                     <label>Gris Artense</label>
                     <Price>
                        <basePrice>720.00</basePrice>
                        <netPrice>720.00</netPrice>
                        <discount>0.00</discount>
                     </Price>
                     <assembly>1</assembly>
                     <isDefault>false</isDefault>
                  </ExteriorFeatures>
                  <ExteriorFeatures>
                     <id>0MM60NN9</id>
                     <code>0M#1#0MM60NN9</code>
                     <rank>10</rank>
                     <classe>0M</classe>
                     <label>Blanc Nacré</label>
                     <Price>
                        <basePrice>920.00</basePrice>
                        <netPrice>920.00</netPrice>
                        <discount>0.00</discount>
                     </Price>
                     <assembly>1</assembly>
                     <selection>user</selection>
                     <isDefault>false</isDefault>
                  </ExteriorFeatures>
                  <ExteriorFeatures>
                     <id>0MP00N9G</id>
                     <code>0M#1#0MP00N9G</code>
                     <rank>68</rank>
                     <classe>0M</classe>
                     <label>Gris Hurricane</label>
                     <Price>
                        <basePrice>0.00</basePrice>
                        <netPrice>0.00</netPrice>
                        <discount>0.00</discount>
                     </Price>
                     <assembly>1</assembly>
                     <isDefault>false</isDefault>
                  </ExteriorFeatures>
                  <ExteriorFeatures>
                     <id>0MM00NEG</id>
                     <code>0M#1#0MM00NEG</code>
                     <rank>253</rank>
                     <classe>0M</classe>
                     <label>Bleu Magnetik</label>
                     <Price>
                        <basePrice>720.00</basePrice>
                        <netPrice>720.00</netPrice>
                        <discount>0.00</discount>
                     </Price>
                     <assembly>1</assembly>
                     <isDefault>false</isDefault>
                  </ExteriorFeatures>
                  <ExteriorFeatures>
                     <id>0MM50NF3</id>
                     <code>0M#1#0MM50NF3</code>
                     <rank>700</rank>
                     <classe>0M</classe>
                     <label>Rouge Ultimate</label>
                     <Price>
                        <basePrice>920.00</basePrice>
                        <netPrice>920.00</netPrice>
                        <discount>0.00</discount>
                     </Price>
                     <assembly>1</assembly>
                     <isDefault>false</isDefault>
                  </ExteriorFeatures>
               </LookFeatures>
               <FlagWLTP>true</FlagWLTP>
               <BaseVersion>1PT9A5TLHKB0A0D0</BaseVersion>
               <WLTPCharacteristics>
                  <Status>
                     <Code>OKW00001</Code>
                     <Desc>Calculation successful</Desc>
                  </Status>
                  <PhysResult VehType="CONV" Category="M1" Destination="EURO6.2-MKTG">
                     <Result>
                        <Code>MASSE</Code>
                        <Value>1313</Value>
                     </Result>
                     <Result>
                        <Code>UMASSE</Code>
                        <Value>1026.9</Value>
                     </Result>
                     <Result>
                        <Code>EMASSE</Code>
                        <Value>211.3</Value>
                     </Result>
                     <Result>
                        <Code>USCX</Code>
                        <Value>0.717</Value>
                     </Result>
                     <Result>
                        <Code>ESCX</Code>
                        <Value>0.004</Value>
                     </Result>
                     <Result>
                        <Code>SCX</Code>
                        <Value>0.721</Value>
                     </Result>
                     <Result>
                        <Code>CRR</Code>
                        <Value>9.8</Value>
                     </Result>
                     <Result>
                        <Code>F0</Code>
                        <Value>125.7</Value>
                     </Result>
                     <Result>
                        <Code>F1</Code>
                        <Value>0.455</Value>
                     </Result>
                     <Result>
                        <Code>F2</Code>
                        <Value>0.033</Value>
                     </Result>
                     <Result>
                        <Code>TMASSE</Code>
                        <Value>1400</Value>
                     </Result>
                  </PhysResult>
                  <Phase Code="HIGH">
                     <WLTPCharacteristic>
                        <Id>CE</Id>
                        <Value>3280774</Value>
                     </WLTPCharacteristic>
                     <WLTPCharacteristic>
                        <Id>FC</Id>
                        <Value>5.4</Value>
                     </WLTPCharacteristic>
                     <WLTPCharacteristic>
                        <Id>CO2</Id>
                        <Value>121</Value>
                     </WLTPCharacteristic>
                  </Phase>
                  <Phase Code="LOW">
                     <WLTPCharacteristic>
                        <Id>CE</Id>
                        <Value>1228206</Value>
                     </WLTPCharacteristic>
                     <WLTPCharacteristic>
                        <Id>FC</Id>
                        <Value>8.2</Value>
                     </WLTPCharacteristic>
                     <WLTPCharacteristic>
                        <Id>CO2</Id>
                        <Value>184</Value>
                     </WLTPCharacteristic>
                  </Phase>
                  <Phase Code="EHIGH">
                     <WLTPCharacteristic>
                        <Id>CE</Id>
                        <Value>5155751</Value>
                     </WLTPCharacteristic>
                     <WLTPCharacteristic>
                        <Id>FC</Id>
                        <Value>6.4</Value>
                     </WLTPCharacteristic>
                     <WLTPCharacteristic>
                        <Id>CO2</Id>
                        <Value>144</Value>
                     </WLTPCharacteristic>
                  </Phase>
                  <Phase Code="MID">
                     <WLTPCharacteristic>
                        <Id>CE</Id>
                        <Value>2138138</Value>
                     </WLTPCharacteristic>
                     <WLTPCharacteristic>
                        <Id>FC</Id>
                        <Value>6.1</Value>
                     </WLTPCharacteristic>
                     <WLTPCharacteristic>
                        <Id>CO2</Id>
                        <Value>138</Value>
                     </WLTPCharacteristic>
                  </Phase>
                  <Phase Code="COMB">
                     <WLTPCharacteristic>
                        <Id>CE</Id>
                        <Value>11802869</Value>
                     </WLTPCharacteristic>
                     <WLTPCharacteristic>
                        <Id>FC</Id>
                        <Value>6.3</Value>
                     </WLTPCharacteristic>
                     <WLTPCharacteristic>
                        <Id>CO2</Id>
                        <Value>141</Value>
                     </WLTPCharacteristic>
                  </Phase>
               </WLTPCharacteristics>
               <GrTypeBoiteVitesse>
                  <id>TV000001</id>
                  <label>Handgeschakeld</label>
               </GrTypeBoiteVitesse>
               <DerivedModels>
                  <id>VP1PT900</id>
                  <label>Nieuwe 308</label>
               </DerivedModels>
            </Version>
         </ConfigResponseV2>
      </ns1:ConfigV2Response>
   </soap:Body>
</soap:Envelope>
````



````
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
   <soapenv:Body>
      <ConfigV2 xmlns="http://xml.inetpsa.com/Services/Cfg/Config">
         <ns1:Config xmlns:ns1="http://inetpsa.com/cfg">
            <ns1:ContextRequest>
               <ns1:Client>Livia</ns1:Client>
               <ns1:Brand>P</ns1:Brand>
               <ns1:Country>NL</ns1:Country>
               <ns1:Date>2018-07-31</ns1:Date>
               <ns1:LanguageID>NL</ns1:LanguageID>
               <ns1:Network>false</ns1:Network>
               <ns1:TaxIncluded>true</ns1:TaxIncluded>
               <ns1:TariffZone>001</ns1:TariffZone>
               <ns1:LocalCurrency>false</ns1:LocalCurrency>
               <ns1:ShowUnavailableLooks>true</ns1:ShowUnavailableLooks>
               <ns1:ShowUnavailableOptionalFeatures>true</ns1:ShowUnavailableOptionalFeatures>
            </ns1:ContextRequest>
            <ns1:ConfigCriteria>
               <ns1:Version>1PT9A5TLHKB0A0D0</ns1:Version>
               <ns1:WLTP>
                  <ns1:FlagWLTP>true</ns1:FlagWLTP>
                  <ns1:PhaseWLTP>FULL</ns1:PhaseWLTP>
               </ns1:WLTP>
               <ns1:Feature>
                  <ns1:id>0MM00N9V</ns1:id>
               </ns1:Feature>
               <ns1:Feature>
                  <ns1:id>0P1U0RFJ</ns1:id>
               </ns1:Feature>
            </ns1:ConfigCriteria>
         </ns1:Config>
      </ConfigV2>
   </soapenv:Body>
</soapenv:Envelope>
````






