# DBFlowManager

[ ![Download](https://api.bintray.com/packages/wajahatkarim3/DBFlowManager/com.wajahatkarim3.DBFlowManager/images/download.svg?version=3.1.1) ](https://bintray.com/wajahatkarim3/DBFlowManager/com.wajahatkarim3.DBFlowManager/3.1.1/link)

A quick and easy database manager and viewer plugin library for your DBFlow databases to view, insert, delete, update the tables directly inside your app.
## Inspiration & Description
Databases are the crucial part in mobile apps these days. And in android, SQLite is the go-to solution for integrating databases. Recently, [RaizLabs DBFlow][dflib] has been proven to be quite easy and fast ORM for SQLite databases. But, to test SQLite databases in app, I was using [DatabaseManager][dmlib], but it wasn't compatible with DBFlow. So, I created this [DBFlowManager][dbmlib] for this purpose.
In short, 
```
DBFlow + DatabaseManager = DBFlowManager
```
Using this library, you can easily view, insert, delete, update the tables of your app's DBFlow database directly from your app by using just a single line of code.

## Features
  - View all your tables data in tabular format
  - Insert rows to your tables
  - Update rows
  - Delete rows
  - Delete tables
  - Drop tables
  - Write your own custom queries and view the results. (Create statements, joins, etc)
  - Change data in the tables and see how you application responds

# Demo

Install [Demo.apk][demk] in your device and click on DBFlow Manager Activity button!

# Screenshots
![N|Solid](https://github.com/wajahatkarim3/DBFlowManager/blob/master/Art/screen1.png) ![N|Solid](https://github.com/wajahatkarim3/DBFlowManager/blob/master/Art/screen2.png) ![N|Solid](https://github.com/wajahatkarim3/DBFlowManager/blob/master/Art/screen3.png)
  
# Installation

Add it to your project's root build.gradle with:

```groovy
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```
and then in your app's build.gradle file:
```groovy
dependencies {
  compile 'com.wajahatkarim3.DBFlowManager:DBFlowManager:3.1.1-v1'
}
```

Or add DBFlowManager as a new dependency inside your pom.xml

```xml
<dependency> 
  <groupId>com.wajahatkarim3.DBFlowManager</groupId>
  <artifactId>DBFlowManager</artifactId> 
  <version>3.1.1-v1</version> 
  <type>pom</type> 
</dependency>
```

# How to Use
To start DBFlowManager activity from your activity or fragment:
```java
DBFlowManagerActivity.launchDatabaseManager(context, MyAppDatabase.class);
```
# Libs used in DBFlowManager Library
- DBFlow ([https://github.com/Raizlabs/DBFlow][dflib])
- DatabaseManager ([https://github.com/sanathp/DatabaseManager_For_Android][dmlib])

# Developed By
```groovy
Wajahat Karim - [Click here to send email!][eml]
```
- Website (http://wajahatkarim.com)
- Twitter (http://twitter.com/wajahatkarim)
- Medium (http://www.medium.com/@wajahatkarim3)
- LinkedIn (http://www.linkedin.com/in/wajahatkarim)

# How to Contribute
1. Fork it
2. Create your feature branch (git checkout -b my-new-feature)
3. Commit your changes (git commit -am 'Add some feature')
4. Push to the branch (git push origin my-new-feature)
5. Create new Pull Request

# License

    Copyright 2016 Wajahat Karim

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


[dflib]: <https://github.com/Raizlabs/DBFlow>
[dmlib]: <https://github.com/sanathp/DatabaseManager_For_Android>
[dbmlib]: <https://github.com/wajahatkarim3/DBFlowManager>
[dbmlib]: <https://github.com/wajahatkarim3/DBFlowManager/blob/master/Demo.apk>
[eml]: <mailto:wajahatkarim3@gmail.com>
