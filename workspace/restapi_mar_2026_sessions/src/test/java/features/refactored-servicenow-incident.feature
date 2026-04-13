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

Scenario: Validate user should able to get all records from the incident table in XML format
Given header key as "Accept" and "application/xml"
When method get and endpoint "/{tablename}"
Then response should be success
| statusCode | statusMessage | responseFormat |
| 200        | OK            | XML            |

Scenario Outline: Validate user should able to create new record in the incident table
Given header key as "Content-Type" and "application/json"
And request body
"""
{
    "short_description": "<ShortDescription>",
    "description": "<Description>",
    "category": "<Category>"
}
"""
When method post "/{tablename}"
Then response should be success
| statusCode | statusMessage | responseFormat |
| 201        | Created       | JSON           |
And response body short_description key should have "<ShortDescription>" value
And response body description key should have "<Description>" value
And response body category key should have "<Category>" value

Examples:
| ShortDescription | Description                           | Category |
| Hardware request | create record for the harware request | hardware |
| Software request | create record for the software request| software |