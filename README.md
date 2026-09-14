# Ashish Atte Production-Oriented Android App

## What this version does
- Android app for ~150 employees
- Firebase Authentication + Firestore
- Admin dashboard
- Employee attendance
- Fixed office geofence/radius verification
- Check-in / check-out
- Camera selfie capture as optional attendance evidence
- Server timestamp field
- Attendance history/report queries
- CSV export helper
- Offline-first local queue architecture notes
- Firestore security rules with role-based access pattern

## Biometric limitation
This project intentionally does NOT perform face identification or make employment decisions from biometric data. A camera can capture an optional selfie as evidence, but identity is established using authenticated employee accounts (or an organization-issued QR/token flow).

If your organization requires biometric identification, use a specialist, legally reviewed biometric system with explicit consent, retention controls, audit logging, liveness, and applicable employment/privacy compliance.

## Setup
1. Create a Firebase project.
2. Enable Email/Password authentication (or your chosen organization identity provider).
3. Create Firestore.
4. Put `google-services.json` into `app/`.
5. Set an admin custom claim (`admin=true`) using a trusted backend.
6. Configure office coordinates/radius in Firestore: `settings/office`.
7. Build with Android Studio.
8. Test GPS accuracy, background restrictions, clock tampering, offline sync, and permission denial before deployment.

## Firestore collections
- employees/{uid}
- attendance/{attendanceId}
- settings/office
- auditLogs/{id}

## Attendance acceptance
Attendance should be accepted only when:
- the employee is authenticated,
- account is active,
- device location is available,
- distance <= configured radius,
- server-side timestamp is recorded.

The app never trusts a client-supplied "present" flag.

## Release checklist
- Configure Firebase App Check.
- Enable Play Integrity where appropriate.
- Add backend Cloud Functions for admin-only operations.
- Add organization privacy notice and employee consent process.
- Define retention/deletion policy.
- Protect exported attendance reports.
- Use a release signing key and Play Console internal testing.
