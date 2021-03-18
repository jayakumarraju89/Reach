Feature: login reach admin portal

  @tag1
  Scenario: login reach admin portal
    And verify login sucessful and and landed in tenant tab
    When search for sampleTd as tenant in search filter
    And click on sampleTd entry from the list
    And verify SampleTD tenant page is opened
    And Navigate to the Tenant url and click on the url
    And Enter email and password then click on login button
    Then Get count from open tab and validate with total entries
    And Get count from submitted tab and validate with total entries

    
