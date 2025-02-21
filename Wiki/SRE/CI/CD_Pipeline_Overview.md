CI/CD Pipeline Overview

1. SDLC with CI/CD
The software development life cycle (SDLC) encompasses several critical phases: development, testing, deployment, and maintenance. CI/CD (Continuous Integration and Continuous Delivery/Deployment) streamlines these phases by automating and integrating them, enabling faster and more reliable software releases.

When code is pushed to a Git repository, it initiates an automated build and testing process. End-to-end (e2e) test cases are executed to verify the code's functionality. If the tests pass, the code can be automatically deployed to staging or production environments. If issues are detected, the code is returned to the development phase for fixes. This automation provides developers with rapid feedback and minimizes the risk of bugs reaching production.

2. Difference between CI and CD
Continuous Integration (CI) focuses on automating the build, test, and merge processes. It runs tests whenever new code is committed, helping to identify integration issues early in the development cycle. This practice encourages frequent code commits and ensures quick feedback for developers.

Continuous Delivery (CD) automates the release processes, including infrastructure changes and deployment. It ensures that software can be reliably released at any time through automated workflows. CD may also automate manual testing and approval steps that are typically required before deploying to production.

3. CI/CD Pipeline
A standard CI/CD pipeline consists of several interconnected stages:
- A developer commits code changes to the source control system.
- The CI server detects the changes and triggers a build process.
- The code is compiled and tested (e.g., unit tests, integration tests).
- Test results are reported back to the developer.
- If the tests pass, the resulting artifacts are deployed to staging environments.
- Additional testing may be conducted in the staging environment before the final release.
- The CD system deploys the approved changes to the production environment.
  
![image](https://github.com/user-attachments/assets/c55f7ac2-8bd4-4060-bd47-9b9041dd8173)

Source/Credit: https://www.linkedin.com/posts/bytebytego_systemdesign-coding-interviewtips-activity-7298576563724300288-Qw1y?utm_source=share&utm_medium=member_desktop&rcm=ACoAAAuCFoEBr0wIThjUffMBsW-JkEVk_F-j3y0
