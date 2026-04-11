Feature: Validate CRUD operation of the servicenow incident table api

Scenario: Validate user should able to get all records from the incident table
Given baseuri "https://dev373619.service-now.com"
And basepath "/api/now/table"
And basic auth username as "admin" and password "7d3iJH=K$jYf"
And path varaiable name as "tablename" and value as "incident"
When method get and endpoint "/{tablename}"
Then status code 200

Scenario: Validate user should able to get all records from the incident table in XML format
Given baseuri "https://dev373619.service-now.com"
And basepath "/api/now/table"
And basic auth username as "admin" and password "7d3iJH=K$jYf"
And path varaiable name as "tablename" and value as "incident"
And header key as "Accept" and "application/xml"
When method get and endpoint "/{tablename}"
Then status code 200
And response format XML

Scenario: Validate user should able to create new record in the incident table
Given baseuri "https://dev373619.service-now.com"
And basepath "/api/now/table"
And basic auth username as "admin" and password "7d3iJH=K$jYf"
And path varaiable name as "tablename" and value as "incident"
And header key as "Content-Type" and "application/json"
And request body
"""
{
    "short_description": "RESTAPIMAR2026"
}
"""
When method post "/{tablename}"
Then status code 201
And status line Created
And response format json