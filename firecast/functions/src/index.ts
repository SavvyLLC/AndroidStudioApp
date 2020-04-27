import * as functions from 'firebase-functions';
import * as admin from 'firebase-admin'
admin.initializeApp()

// Start writing Firebase Functions
// https://firebase.google.com/docs/functions/typescript

export const onBostonWeatherUpdate = 
functions.firestore.document("users/*").onUpdate( change => {
    const after = change.after.data()


    console.log("TESSSSSSSSSSSST")
    console.log(after!.firstName + after!.lastName)

    

    // const users = functions.firestore.document('users');
    // const allUsers = users.get()



    

    
    
    // forEach(element => {

    //     //Check Id against after to make sure we aren't checking our own document
        
    //     after.matches.array.forEach((value: boolean, key: string) => {
            
    //         if(element.data().matches.has(key)){
    //             const curPayload = element.data()
    //             curPayload.matches[key] = true;
    //             return admin.messaging().sendToTopic(element.getUuid(), payload)
    //             .catch(err => handle(err))
    //             .then(() => console.log('this will succeed'))//Updates the current payload
    //         }
    //     });
    // });

    const payload = {
        data: {
            firstName: after!.firstName,
            lastName: after!.lastName,
            
        }
    }

    return admin.messaging().sendToTopic("testStudentForSwiping2", payload)
});

export const helloWorld = functions.https.onRequest((request, response) => {
 response.send("Hello from Firebase!");
});
 
