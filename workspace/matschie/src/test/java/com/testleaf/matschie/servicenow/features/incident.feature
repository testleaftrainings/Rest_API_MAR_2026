Feature: Validate CRUD operation of the servicenow incident table api

Background:
Given baseuri "https://dev373619.service-now.com"
And basepath "/api/now/table"
And basic auth username as "admin" and password "7d3iJH=K$jYf"
And path varaiable name as "tablename" and value as "incident"

Scenario: Validate user should able to get all records from the incident table
When method get and endpoint "/{tablename}"
Then response should be success
| statusCode | statusMessage | responseFormat |
| 200        | OK            | JSON           |

Scenario: Validate user should able to create new record into the incident table
Given header key as "Content-Type" and "application/json"
When method post "/{tablename}"
Then response should be success
| statusCode | statusMessage | responseFormat |
| 201        | Created       | JSON           |