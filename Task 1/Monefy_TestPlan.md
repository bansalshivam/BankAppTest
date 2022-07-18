# Monefy Test Plan
## _Test Strategy, Test Suite, Test Cases_


## Introduction
---
While preparing a test Plan multiple aspects can be considered. This test plan is prepared considering general & mobile application specific aspects which are further combined in two major aspect for an application.

1. General Aspects
    
    * Features
    * UI / Usability scenarios
    * Install / Upgrade
    * Performance
    * Security
    * System Interaction


2. Mobile Specific Aspects

    * Multiple device compatibility with customized OS version.
    * Backward compatibility with different OS version.
    * Testing on different screen resolution.

Above aspects are divided into further two categories :

1. Functional Test Cases
2. Non Functional Test cases


### Test Strategy
---
- Test cases are divided into suites which consists specific test cases to test a particular feature or area.
- Strategy followed while preparing this test plan is test pyramid which is widely used and most efficient for testing mobile application.
![N|Solid](https://d2h1nbmw1jjnl.cloudfront.net/ckeditor/pictures/data/000/000/784/content/testpyramid_2.png)
- Prioritization of the test cases according to the business impact are divided into three categories. `High Priority`, `Medium Priority`, `Low Priority`


### Functional Test Cases
---
##### Scenario 1 : Install/Upgrade/Compatibility

* > Test_Suite_1
    
    | Priority | Test Case Description | Expected Result |
    | -------- |---------------------- | --------------- |
    | `High Priority` | Installation of app from play store (android).| Installation should be successful.|
    | `High Priority` | Upgrade of app to the latest version | Validate the user data, settings. They should be same.|
    | `High Priority` | Installation of app on different devices & OS versions.| Validate the app should be installed.|
    | `High Priority` | Add & Remove required permission for app. | App should work fine in case of full and less permission.|
    | `High Priority` | Uninstall the app & install it again. | App should be uninstalled properly & after install data should be restored. |
    | `High Priority` | Validate App after system OS upgrade. | Validate the user data and app should work fine.|

##### Scenario 2 : Feature Especial

1. Account Feature
* > Test_Suite_2

    | Priority | Test Case Description | Expected Result |
    | -------- |---------------------- | --------------- |
    | `High Priority` | Add an account with default parameters.| Account should be successfully created.|
    | `High Priority` | Edit the account details. | Updation should be successful.
    | `High Priority` | Delete the account. | Validate the account should be properly deleted and user income/expenses related to the account also deleted.|
    | `High Priority` | Create multiple account and switch between the account. | User should be able to switch between account properly and selected account data should be reflected. |

2. Income & Expense Feature
* > Test_Suite_3
    
    | Priority | Test Case Description | Expected Result |
    | -------- |---------------------- | --------------- |
    | `High Priority` | Add Income and expenses for multiple categories | Income / Expense should be added & balance should be updated according to amount added.|
    | `High Priority` | Edit Income and expenses for multiple categories | Updation should be successful & balance should be updated according to amount edited. |
    | `High Priority` | Delete income and expenses for multiple categories | Validate the amount should be properly deleted & balance should be updated. |
    | `High Priority` | Change payment method while adding/updating expense | Account should be changeable while adding amount. |

3. Transfer Feature
* > Test_Suite_4

    | Priority | Test Case Description | Expected Result |
    | -------- |---------------------- | --------------- |
    | `High Priority` | Click on New Transfer button from home page. | User should be able to view all the accounts. |
    | `High Priority` | Transfer amount from one account to another account. | Fund should be transferred and charts should be updated. |
    | `Low Priority` | Transfer amount from same account to same account. | User should not be able to transfer the amount. |

4. Pro Features    
* > Test_Suite_5

    | Priority | Test Case Description | Expected Result |
    | -------- |---------------------- | --------------- |
    | `High Priority` | As a free user, Access Pro features like custom category/Multi-currency/synchronization/Passcode etc. | Features should not be accessbile and prompt to buy monefy pro. |
    | `High Priority` | As a free user, Buy Monefy pro using different payment methods. | User should be able to buy pro. |
    | `High Priority` | As a pro user, Access Pro features like custom category/Multi-currency/synchronization/Passcode etc. | Features should be accessbile to the user. |

##### Scenario 3 : UI / Usability
* > Test_Suite_6 

    | Priority | Test Case Description | Expected Result |
    | -------- |---------------------- | --------------- |
    | `High Priority` | Change language to other lanuage. | Data should be present & and all the information should be localized. |
    | `High Priority` | Swipe balance button Up/down. | User should be able to swipe. |
    | `High Priority` | Select day/week/month/year/interval from filters. | User should be able to change filters and data/charts should be updated based on the filters. |
    | `Medium Priority` | Swipe left & right between Day/Weeks. | User should be able to swipe left and right. |
    | `Medium Priority` | Send app to background with multiple app and load it again. | App's state should be intact and data should be present. |

##### Scenario 4 : Settings 
* > Test_Suite_7 
    (With/Without Pro)

    | Priority | Test Case Description | Expected Result |
    | -------- |---------------------- | --------------- |
    | `High Priority` | (Currency) Change currency to any other currency. | Data should be present & and all the information should be changed according to the currency. |
    | `High Priority` | (Export to file) Select Export to file option from settings | User should be prompted for permission of storage access and selected successfully. |
    | `High Priority` | (Export to file) Change "Character set"/"Decimal separator"/"Delimiter character" | Data should be present in all options & user should be able to change successfully. |
    | `High Priority` | (Export to file) Export data to csv file. | File should be saved and user should be able to access from file storage. |
    | `High Priority` | (About Monefy) Select the "About Monefy" from settings. | Data should be visible to the user |
    | `High Priority` | (About Monefy) Select links present on the "About Monefy" view. | All the links should be accessible & user should switch back to the app |
    | `High Priority` | (About Monefy) Disable/Enable google analytics. | Analytics should be switchable. |
    | `High Priority` | (Privacy Policy) Select "Privacy Policy" from settings | Used should be redirected to the monefy policy page & can switch back to app. |
    | `High Priority` | (Data Backup) Select "Create data Backup" from settings | User should be able to save the backup file. |
    | `High Priority` | (Data Backup) Select "Restore Data" from settings | User should be able to restore data from the backup file. |
    | `Meduim Priority` | (Data Backup) Select "Clear Data" from settings | All the data & data backup should be removed. |
* > Test_Suite_8 
    (With Pro)

    | Priority | Test Case Description | Expected Result |
    | -------- |---------------------- | --------------- |
    | `High Priority` | (Synchronization) Select Dropbox/Google Drive from settings | User should be able to view and export data from both the options. |
    | `High Priority` | (Synchronization) Select Dropbox/Google Drive and let it redirect. | User should be able to login to their account. |
    | `High Priority` | (Passcode Protection) Select a passcode from the settings. | Passcode should be available at app launch |
    | `High Priority` | (Passcode Protection) Launch app & enter passcode. | User should be able to access app. |
    | `Medium Priority` | (Dark theme) Select the dark theme from settings | App theme should be updated. |


### Non-Functional Tests
---
##### Scenario 1 : Security
* > Test_Suite_9 

    | Priority | Test Case Description | Expected Result |
    | -------- |---------------------- | --------------- |
    | `High Priority` | Check for the application data saved. | Data should be encrypted. |
    | `High Priority` | Apply global phone lock passcode to app. | Lock should be applied and user should be able to access app after entering key |
    | `High Priority` | Check for vulnerability library used. | There should not be any vulnerability library present. |

##### Scenario 2 : Performance
* > Test_Suite_10

    | Priority | Test Case Description | Expected Result |
    | -------- |---------------------- | --------------- |
    | `High Priority` | Battery usage of application. | Battery usage should not be rapid. |
    | `High Priority` | Battery usage of application while using internet and completing background tasks in battery save mode. | Battery usage should be optimized to prevent it from blocking. |
    | `High Priority` | Check for the application launch time. | Application launch time should not be more than specified or like (2 Seconds). |
    | `High Priority` | Extensive use of application. | Application should run without a crash. |
    | `High Priority` | Check for CPU/RAM consumption. | App should not over occupy CPU/RAM. |
    
##### Scenario 2 : Recovery
* > Test_Suite_11

    | Priority | Test Case Description | Expected Result |
    | -------- |---------------------- | --------------- |
    | `High Priority` | Launch app after a crash. | App should perform well after the crash and data should not be lost. |
    | `High Priority` | Message on app crash. | User should be able to see crash message and can send crash report to the server. |
    | `High Priority` | App force shutdown from settings. | App should shutdown gracefully and data should be intact. |
    | `Medium Priority` | App shutdown due to battery dies. | App should be closed properly. |
    
##### Scenario 3 : Upgrade/Rollback
* > Test_Suite_12

    | Priority | Test Case Description | Expected Result |
    | -------- |---------------------- | --------------- |
    | `High Priority` | Upgrade of app. | App should not over consume RAM. |
    | `High Priority` | Upgrade on low battery or error during upgrade. | Application should be rolled back propery when upgrade interuppted. |
