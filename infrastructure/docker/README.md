# Push Docker Image to AWS ECR

Login to ECR
<pre>
Johns-MBP:mp3-tagger admin$ aws ecr get-login
docker login -u AWS -p eyJwYXlsb2FkIjoid0RjdXM5Vy8rdGVmcURmTHVNOXlncG5yYXNBMnVZTk9QUDZ2QmZmK2lMMVlsTFo5YkVQNy8rSHNwR2xOWUpQS3dXWjNCTHg3SXF3MUpYT1o4NFJwZnlZY1lFdW50TGo0L1psdmJJY1ZsQWRoK1NKMXlldGRQSFVCY1RqVlgzUFZ3TVJLK2MxcnZZRUVXZEdhdEQ3K0VGWHZaNWNXY3VqdkhIMmxRL0JlcG1XZFpaSzJUMkNMYUd3eGp5RHVKZVhrZWRKalFURnd0bnFmU0RaZS83N3UzUEVGcytLZ3dDTy95UHlrcDZjUXc3OTdNZmQ5WHQ0eUZMdW9mSnZHN21PTTB3U3VWR1NCNkJKLzdkVE9uUEU2eTJ2dWNyaTRwYzNkSlZZTnhHYWoxWjdyMlo2Y3FOT04wdEsrbHBJaFc4djRUdTJISGpHWU1qYWdrckpzQ051c0JVVDdob2FrdWlxOTZpYys3Qm5BR0wvS2IrMGZ0dDc5aElWZUFjR1ZwcUZmaVlpL1FBSllGU01LWG40QnZMbGpmYXQzRVRCWGYyTTN3Rkk5a2lwWS9LdGRZeml4VG9BQnIzcmo0U1JNenV4cHdyaFNyQ3lCcDBtTDkrQVBFOWlEOGtZUUNlNDIxLzk1UzVsUW4yRTcwRDFMc3lXWWNXVjFVWkRiTzR2ZDlDbnRsZDJ0ME5QL3hCd0hheW40dmcyems1SzJ6c2EzMlpVbk04M29BRkhnSytpY3JnYkJzRXE2UmhraGJNKzJYck1QMHNRZmozejk3c2JPa1pGSFRqN0R5V1g5NnJWOFQ1SmFLQ0hHdXArRDh4ZTRhQVFEVEZtaGlydkYrTFBiSlFUNlorVnlMa2JjVnVDMHNRTkMxN1lHR0pHeGNoVXpPQzdXNm9WbnBpZlFoMnNUcmpESzkrRzRDdnZFWGZvZlQ2MzBxVUVKemhXOHR1WnR5MmJRSUlEMS9aeTE4eVd0ajBXaVcyZENrZU5vcno0WmhZeGowaGczQUtFdkJkZWlTZWhjWXkyemE2ZktwYmFiRFg3OHY4RzJaMEJuajhrWGsxWGZUcjYzNE4wL1ZacE1RS1JQNVZKR2NaZ2hnUlg4amtETE8rTEJRNXV0S2RLbWZFQ1VlcHdDR0h4VGdPdnVZb0RXT0FERkthUHY2THdaVnhoOFZOR2hIelZMSFJqdFZmZTE3QXVuanBRb2g1WHNzSm94ano4THFwWVMyYmQ3VFZDa2lJNzE3QUNpUmlLeTZpWmN1cVBabGZCTzQvRkQwQ2ptT1RrVGZudzExaWxuT2Z2VHkzOVdyLzRxckMyLy9mNFNRVDk4TTFBSU51ZFdQTWh4Ykx1RDk2dmM2bkluaHBOWVRiV3laRDN0OWV2VzFCd0kxbllJbHBNSHNvSUFTQmgwNGlmNGhnZnZPMUozN2RNT1JON1ZnSDM4amkzMDBDSjlFd2QveVAwTjFLOHViRVVtcVF5d05keEFzZVJIbHc9PSIsImRhdGFrZXkiOiJBUUVCQUhod20wWWFJU0plUnRKbTVuMUc2dXFlZWtYdW9YWFBlNVVGY2U5UnE4LzE0d0FBQUg0d2ZBWUpLb1pJaHZjTkFRY0dvRzh3YlFJQkFEQm9CZ2txaGtpRzl3MEJCd0V3SGdZSllJWklBV1VEQkFFdU1CRUVES25oTjJKZG4wUFpqSldjZkFJQkVJQTdoSk9iazROVFRuVElZS2dZelAxL0hlQTFlQkdCVy9nQnJ3cHRSakIzWTRpSHhVRGMvczBvSTFFTFhuMjN2dk1vOCtuaWZNZkJveit1eUt3PSIsInZlcnNpb24iOiIyIiwidHlwZSI6IkRBVEFfS0VZIiwiZXhwaXJhdGlvbiI6MTUzNjc5NTAzM30= https://002609254882.dkr.ecr.us-east-1.amazonaws.com


Johns-MBP:mp3-tagger admin$ docker login -u AWS -p eyJwYXlsb2FkIjoid0RjdXM5Vy8rdGVmcURmTHVNOXlncG5yYXNBMnVZTk9QUDZ2QmZmK2lMMVlsTFo5YkVQNy8rSHNwR2xOWUpQS3dXWjNCTHg3SXF3MUpYT1o4NFJwZnlZY1lFdW50TGo0L1psdmJJY1ZsQWRoK1NKMXlldGRQSFVCY1RqVlgzUFZ3TVJLK2MxcnZZRUVXZEdhdEQ3K0VGWHZaNWNXY3VqdkhIMmxRL0JlcG1XZFpaSzJUMkNMYUd3eGp5RHVKZVhrZWRKalFURnd0bnFmU0RaZS83N3UzUEVGcytLZ3dDTy95UHlrcDZjUXc3OTdNZmQ5WHQ0eUZMdW9mSnZHN21PTTB3U3VWR1NCNkJKLzdkVE9uUEU2eTJ2dWNyaTRwYzNkSlZZTnhHYWoxWjdyMlo2Y3FOT04wdEsrbHBJaFc4djRUdTJISGpHWU1qYWdrckpzQ051c0JVVDdob2FrdWlxOTZpYys3Qm5BR0wvS2IrMGZ0dDc5aElWZUFjR1ZwcUZmaVlpL1FBSllGU01LWG40QnZMbGpmYXQzRVRCWGYyTTN3Rkk5a2lwWS9LdGRZeml4VG9BQnIzcmo0U1JNenV4cHdyaFNyQ3lCcDBtTDkrQVBFOWlEOGtZUUNlNDIxLzk1UzVsUW4yRTcwRDFMc3lXWWNXVjFVWkRiTzR2ZDlDbnRsZDJ0ME5QL3hCd0hheW40dmcyems1SzJ6c2EzMlpVbk04M29BRkhnSytpY3JnYkJzRXE2UmhraGJNKzJYck1QMHNRZmozejk3c2JPa1pGSFRqN0R5V1g5NnJWOFQ1SmFLQ0hHdXArRDh4ZTRhQVFEVEZtaGlydkYrTFBiSlFUNlorVnlMa2JjVnVDMHNRTkMxN1lHR0pHeGNoVXpPQzdXNm9WbnBpZlFoMnNUcmpESzkrRzRDdnZFWGZvZlQ2MzBxVUVKemhXOHR1WnR5MmJRSUlEMS9aeTE4eVd0ajBXaVcyZENrZU5vcno0WmhZeGowaGczQUtFdkJkZWlTZWhjWXkyemE2ZktwYmFiRFg3OHY4RzJaMEJuajhrWGsxWGZUcjYzNE4wL1ZacE1RS1JQNVZKR2NaZ2hnUlg4amtETE8rTEJRNXV0S2RLbWZFQ1VlcHdDR0h4VGdPdnVZb0RXT0FERkthUHY2THdaVnhoOFZOR2hIelZMSFJqdFZmZTE3QXVuanBRb2g1WHNzSm94ano4THFwWVMyYmQ3VFZDa2lJNzE3QUNpUmlLeTZpWmN1cVBabGZCTzQvRkQwQ2ptT1RrVGZudzExaWxuT2Z2VHkzOVdyLzRxckMyLy9mNFNRVDk4TTFBSU51ZFdQTWh4Ykx1RDk2dmM2bkluaHBOWVRiV3laRDN0OWV2VzFCd0kxbllJbHBNSHNvSUFTQmgwNGlmNGhnZnZPMUozN2RNT1JON1ZnSDM4amkzMDBDSjlFd2QveVAwTjFLOHViRVVtcVF5d05keEFzZVJIbHc9PSIsImRhdGFrZXkiOiJBUUVCQUhod20wWWFJU0plUnRKbTVuMUc2dXFlZWtYdW9YWFBlNVVGY2U5UnE4LzE0d0FBQUg0d2ZBWUpLb1pJaHZjTkFRY0dvRzh3YlFJQkFEQm9CZ2txaGtpRzl3MEJCd0V3SGdZSllJWklBV1VEQkFFdU1CRUVES25oTjJKZG4wUFpqSldjZkFJQkVJQTdoSk9iazROVFRuVElZS2dZelAxL0hlQTFlQkdCVy9nQnJ3cHRSakIzWTRpSHhVRGMvczBvSTFFTFhuMjN2dk1vOCtuaWZNZkJveit1eUt3PSIsInZlcnNpb24iOiIyIiwidHlwZSI6IkRBVEFfS0VZIiwiZXhwaXJhdGlvbiI6MTUzNjc5NTAzM30= https://002609254882.dkr.ecr.us-east-1.amazonaws.com
WARNING! Using --password via the CLI is insecure. Use --password-stdin.
Login Succeeded
</pre>

Push the Docker image to AWS ECR

<pre>
Johns-MBP:mp3-tagger admin$ docker images
REPOSITORY                      TAG                 IMAGE ID            CREATED             SIZE
com.rental/rental-service-api   0.0.1-SNAPSHOT      8af7bfbf81a0        2 days ago          244MB

Johns-MBP:mp3-tagger admin$ docker tag 8af7bfbf81a0 002609254882.dkr.ecr.us-east-1.amazonaws.com/production:latest

Johns-MBP:mp3-tagger admin$ docker push 002609254882.dkr.ecr.us-east-1.amazonaws.com/production:latest

The push refers to repository [002609254882.dkr.ecr.us-east-1.amazonaws.com/production]
9d9d00c948d2: Pushed 
10f2773e4e26: Pushed 
79fed84e2c60: Pushed 
2fd640341bb9: Pushed 
5bef08742407: Pushed 
latest: digest: sha256:a82bffdc24cba3b9fca9899985278842781641cf4a9e9acf9ec5f9e3ab6696df size: 1375
</pre>