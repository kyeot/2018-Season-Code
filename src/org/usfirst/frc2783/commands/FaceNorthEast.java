package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FaceNorthEast extends Command {

    public FaceNorthEast() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.tankDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.tankDrive.setRobotPose(new Bearing(315));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    
    /* long time ago, in a galaxy far, far away....

TITLE CARD: There is unrest in the Galactic Senate. Several thousand solar systems have declared their intentions to leave the Republic. This separatist movement, under the leadership of the mysterious Count Dooku, has made it difficult for the limited number of Jedi Knights to maintain peace and order in the galaxy. Senator Amidala, the former Queen of Naboo, is returning to the Galactic Senate to vote on the critical issue of creating an ARMY OF THE REPUBLIC To assist the overwhelmed Jedi…

[The text fades away, and a planet, Coruscant, the capital of the Galaxy, comes into view, as does a shining starship and two smaller guard ships.]

[Aboard Senator’s Ship]

Lieutenant: Senator, we’re making our final approach into Coruscant.

‘Senator’ (Cordé): Very good, Lieutenant.

[They make their way through a layer of fog, and then land safely on a landing platform amongst the flying traffic and tall skyscrapers. The pilots of the guard ships get out, and one (Captain Typho) takes his helmet off. The ‘Senator’ gets off the larger spacecraft.]

[On Landing Platform]

Typho: We made it. I guess I was wrong. There was no danger at all.

[Just as the ‘Senator’ gets off her ship, it explodes. Debris flies everywhere. Typho and the other guard rush forward. The other guard takes off her helmet, and is revealed to be the real Senator. The other was a decoy for protection. Sen. Padmé Amidala rushes to her decoy.]

Padmé: Cordé!

Cordé: *faintly* My lady… So sorry… I’ve failed you Senator…

Padmé: *whimpering* No…

[Cordé rolls onto her side, dead. Typho approaches.]

Typho: My lady, we’re still in danger here.

Padmé: I shouldn’t have come back.

Typho: This vote is very important. You do your duty; Cordé did hers, now come.

[Typho takes a step, Padmé doesn’t follow.]

Typho: Senator Amidala, Please.

[Both Leave]

[A Large Dome-Shaped Building: The Chancellor’s Palace. Inside a meeting room are six members of the Jedi Order and Chancellor Palpatine.]

Chancellor Palpatine: I don’t know how much longer I can hold off the vote, my friends. More and more star systems are joining the separatists.

Mace Windu: If they do break away-

Palpatine: I will not let this republic that has stood for a thousand years be split in two. My negotiations will not fail.

Windu: If they do, you must realize that there aren’t enough Jedi to protect the Republic. We’re Keepers of the Peace, not soldiers.

Palpatine: Master Yoda- do you think it will really come to war?

Yoda: *thinks* The Dark Side clouds everything. Impossible to see, the future is.

[A Hologram Message pops up on the Chancellor’s Desk. An Alien is projected.]

Hologram Alien: (speaking Huttese) The Loyalist Committee has arrived, your Honor.

Palpatine: Good. Send them in.

[Hologram flickers out]

Palpatine: We will discuss this matter later.

[Door opens, the Loyalists (including Padmé) enter, while the Jedi exit.]

Yoda (to Padmé): Senator Amidala… Your tragedy on the landing platform… terrible. Seeing you alive brings warm feelings to my heart.

Padmé: Do you have any idea who’s behind this attack?

Windu: Our intelligence points to disgruntled spice miners on the moons of Naboo.

Padmé: I think Count Dooku is behind it.

Ki Adi-Mundi: He’s a political idealist, not a murderer.

Windu: You know, milady, Count Dooku was once a Jedi. He couldn’t assassinate anyone: it’s not in his character.

Yoda: But, for certain Senator, in grave danger you are.

Palpatine: Master Jedi… may I suggest the senator be placed under the protection of your graces.

Bail Organa: Do you really think that’s a wise decision under these stressful times?

Padmé: Chancellor, if I may comment I do not believe-

Palpatine: …the situation is that serious. No, but I do, Senator. I realize all too well that additional security may be disruptive for you. But, perhaps, someone you’re familiar with. An old friend, like… Master Kenobi.

Windu: That’s possible. He’s just returned from a border dispute on Ansion.

Palpatine: Do it for me, milady, please. The thought of losing you… is unbearable.

Windu: I’ll have Obi-Wan report to you immediately, milady.

Padmé: Thank you, Master Windu.

[A smooth, tall building: Padmé’s temporary home. An elevator is running up the side, containing two people.]

[Anakin straightens out his robes, looking nervous.]

Obi Wan: You seem a little on edge.

Anakin: Not at all.

Obi Wan: I haven’t felt you this tense since… since we fell into that nest of gundarks.

Anakin: *scoffs* You fell into that nightmare, Master, and I rescued you. Remember?

Obi Wan: Oh… yes. *Chuckles* You’re sweating. Relax. Take a deep breath.

Anakin: I haven’t seen her in ten years, master.

[The elevator stops, and they get off. They are approached by Jar-Jar Binks]

Jar Jar: Obi? Obi! Mesa so smilin’ to seein’ yousa.

Obi Wan: Good to see you again, Jar-Jar.

Jar Jar: Senator Padmé! Mesa palos here. Lookie, lookie, Senator. Desa Jedi arriven.

[Padmé walks over, and Obi-Wan bows.]

Obi Wan: It’s a great pleasure to see you again milady.

Padmé: It has been far too long Master Kenobi. *To Anakin* Ani? My goodness, you’ve grown.

Anakin: So have you. Grown more beautiful, I mean. Well, for- for a senator, I mean.

Padmé: Ani, you’ll always be that little boy I knew on Tatooine.

[All walk over to sit at two couches and a low table.]

Obi Wan: Our presence here will be invisible, milady, I can assure you.

Typho: I’m Captain Typho of Her Majesty’s security service. Queen Jamilla has been informed of your assignment. I am grateful you’re here, Master Kenobi. The situation is more dangerous than the Senator will admit to.

Padmé: I don’t need more security, I need answers. I want to know who’s trying to kill me.

Obi Wan: We’re here to protect you, Senator, not to start an investigation.

Anakin: We will find out who’s trying to kill you, Padmé. I promise you.

Obi Wan: We will not exceed our mandate, my young Padawan learner.

Anakin: I meant that in the interest of protecting her, Master, of course.

Obi Wan: We will not go through this exercise again, Anakin, and you will pay attention to my lead.

Anakin: Why?

Obi Wan: What?

Anakin: Why else do you think we were assigned to her if not to find the killer? Protection is a job for local security, not Jedi. It’s overkill, Master; investigation is applies in our mandate.

Obi Wan: We will do exactly as the Council has instructed… and you will learn your place, young one.

Padmé: Perhaps with merely your presence, the mystery surrounding this threat will be revealed. Now, if you’ll excuse me, I will retire.

[All stand as she walks off.]

Typho: I know I’ll feel better with you here. I’ll have an officer stationed at every floor, and I’ll be in the control center downstairs.

Jar Jar: Mesa bustin’ with happiness seein’ yousa again, Ani.

Anakin: She hardly even recognized me, Jar-Jar. I’ve thought about her every day since we parted. She’s forgotten me completely.

Jar Jar: Shesa happy. Happier than mesa seein’ her in a longo time.

Obi Wan: You’re focusing on the negative, Anakin, be mindful of your thoughts. She was pleased to see us. Now, let’s check the security.

[Anakin follows Obi-Wan in one direction, Jar-Jar goes in another.]

[A walkway-type structure on Coruscant around a large, round building. Night has fallen. A green and yellow speeder is parked on the walkway, and someone gets out: Zam Wessel- a hired assassin. Zam meets a strange figure- a bounty hunter clad in blue and gray armor.]

Zam: I hit the ship but they used a decoy. Bounty Hunter: We’ll have to try something more subtle this time, Zam. My client is getting impatient. Here- take these.

[The Bounty Hunter holds out a tube containing two wormlike beasts.]

Bounty Hunter: Be careful- they’re very poisonous. Zam- there can be no mistakes this time.

[Zam walks off]

[Back in Padmé’s temporary home, Anakin and Obi Wan talk.]

Obi Wan: Typho has more than enough men downstairs. No assassin would try that way. Any activity up here?

Anakin: Quiet as a tomb. I don’t like just waiting here for something to happen to her.

Obi Wan: What’s going on?

Anakin: She covered the cameras. I don’t think she liked me watching her.

Obi Wan: What is she thinking?

Anakin: She programmed Artoo to warn us if there is an intruder.

Obi Wan: There are many other ways to kill a senator.

Anakin: I know, but we also want to catch this assassin, don’t we, Master?

Obi Wan: You’re using her as bait.

Anakin: It was her idea. Don’t worry: no harm will come to her. I can sense everything going on in that room. Trust me.

Obi Wan: It’s too risky. Besides, your senses aren’t that attuned my young apprentice.

Anakin: And yours are?

Obi Wan: Possibly.

[Back to Zam and the Walkway.]

[Zam loads the worm tube into a droid, which flies off.]

[Back, again, to Anakin and Obi-Wan.]

Obi Wan: You look tired.

Anakin: I don’t sleep well anymore.

Obi Wan: Because of your mother?

Anakin: *nods* I don’t know why I keep dreaming about her.

Obi Wan: Dreams pass, in time.

Anakin: I’d much rather dream about Padmé. Just being around her is… intoxicating.

Obi Wan: Your thoughts betray you, Anakin. You have made a commitment to the Jedi Order, a commitment not easily broken. And don’t forget, she’s a politician, and they’re not to be trusted.

[In Padmé’s room, the next one over. She is asleep in bed, Artoo is there on guard, and the droid is at the window.]

Anakin: She’s not like the other senators, Master.

Obi Wan: It is my experience that senators focus only on pleasing those who fund their campaigns. And they’re in no means scared of forgetting the niceties of democracy in order to get those funds.

Anakin: Not another lecture… at least not on the economics of politics.

[The droid flies closer to the window, and cuts a circular hole in the glass with a laser. It opens the tube, releasing the large, poisonous worms, which scuttle around, keeping out of Artoo’s sight and creeping closer to Padmé.]

Anakin: And besides, you’re generalizing. The Chancellor doesn’t appear to be corrupt.

Obi Wan: Palpatine is a politician. I have observed that he is very clever in following the passions and the prejudices of senators.

[Back to Anakin and Obi-Wan.]

Anakin: I think he is a good man. But-

Obi Wan: I sense it, too!

[Both rush into Padmé’s room. Anakin jumps up onto her bed, ignites his lightsaber, and chops the creatures in half. Padmé awakens, and Obi-Wan sees the droid back away from the window. He jumps through the window, smashing the glass, and grab hold of the droid. Dormé, Padmé’s Handmaiden, rushes in.]

Anakin: *frantic* Stay here!

Dormé: Are you all right, milady?

[The droid is flying through the city at high speeds, Obi-Wan dangling by his fingertips. The droid smashes Obi-Wan’s hand into a building in an attempt to make him fall.]

[A sort of garage.]

[Anakin rushes around, looks for a speeder, and then hops into one and flies off.]

[Back to Obi-Wan.]

[The droid flies directly through a line of traffic: attempting again to shake Obi-Wan off.]

Alien in Speeder: What the-?

Dug in Speeder: Argh! Jedi poo-doo!

[Over to Zam- still on the balcony.]

[She sees the droid approaching with Obi-Wan on it. Seeing this as a bad sign, she shoots with a rifle, then gets in her speeder and flies off.]

[Back to Obi-Wan.]

[The droid is hit by Zam’s shot, and it explodes. Obi-Wan is forced to let go and stats to fall. The ground is hundreds of feet off- maybe thousands. Luckily, Anakin saves him in his speeder. He crawls into the front seat, and Anakin continues to chase Zam the Assassin through Coruscant.]

Obi Wan: What took you so long?

Anakin: Oh… ah… you know, Master. I couldn’t find a speeder that I really liked.

Obi Wan: There he is. Anakin: With the open cockpit and the right speed capabilities…

Obi Wan: If you spent as much time practicing your saber techniques as you did your wit you would rival Master Yoda as a swordsman.

Anakin: I thought I already did

Obi Wan: Only in your mind, my very young apprentice.

[They take a very violent, steep, and sharp turn down. Anakin keeps going straight down.]

Obi Wan: Pull up Anakin. Pull up!

[He pulls up only when they almost collide with the foundations of a skyscraper.]

Anakin: Whoa-oa!

Obi Wan: You know I don’t like it when you do that!

Anakin: Sorry, Master. I forgot you don’t like flying.

Obi Wan: I don’t mind flying, but what you’re doing is suicide!

[They follow Zam into a trench-sort of area between two buildings. Zam reaches her pistol out the window and shoots a power coupling. Just before it starts to shoot out violet beams of electricity, she passes by. Unfortunately, Anakin and Obi-Wan get zapped.]

Anakin: Ow- ow- ow- ow- ow…

Obi Wan: Anakin! How many times have I told you to stay- away- from- power- couplings…! *pauses* *sarcastic* That was good!

[They fly out of the trench. Zam goes through a tunnel, dodging other speeders and vehicles. Anakin flies out in that general direction, and then takes a right.]

Obi Wan: Where are you going? He went that way!

Anakin: Master, if we keep this chase going any longer that creep is gonna end up deep-fried. Personally, I’d like to know who he is and who he’s working for. This is a shortcut… I think.

[Anakin flies a bit longer and then stops.]

Obi Wan: Well, you’ve lost him.

Anakin: I’m deeply sorry master.

Obi Wan: That was some shortcut, Anakin. He went completely the other way. Once again you’ve proved-

Anakin: If you’ll excuse me…

[Anakin jumps out, falling down until he lands on top of Zam’s speeder.]

Obi Wan: I hate it when he does that.

[Anakin is just barely holding on, and Zam tries to get him off by shooting, suddenly turning down, and pulling up. She turns her head at one point, and a patch of her skin turns greenish and then goes back to normal. Eventually Anakin gets himself on top of the cockpit. He ignites his lightsaber and stabs down at the assassin, but jets go of the handle while avoiding blasts from her pistol. It falls away to be caught by Obi-Wan, who is still following close behind. More blasts from Zam’s pistol set fire to the control panel. She frantically tries to put out the flames and land her ship at the same time. In her frenzy, Anakin falls off, but luckily she was near the ground. A few seconds later, she crash-lands and runs into a club. Anakin follows her, and meets up with Obi-Wan at the entrance.]

Obi Wan: Anakin!

Anakin: She went into the club, Master!

Obi Wan: Patience. Use the Force. Think.

Anakin: Sorry, Master.

Obi Wan: He went in there to hide, not to run.

Anakin: Yes, Master.

[Obi Wan holds out Anakin’s lightsaber.]

Obi Wan: Next time, try not to lose it.

Anakin: I try, Master.

Obi Wan: Why do I get the feeling you’re going to be the death of me?

Anakin: Don’t say that, Master. You’re the closest thing I have to a father.

Obi Wan: Then why don’t you listen to me?

Anakin: I am trying.

[Both walk into the club. Obi-Wan surveys the crowd, looking for Zam.]

Obi Wan: Do you see him?

Anakin: I think that he is a she. And I think that she is a Changeling.

Obi Wan: In that case be extra careful. Go and find her.

Anakin: Where are you going, Master?

Obi Wan: For a drink.

[Both walk off in different directions. Anakin goes wandering in search of Zam, Obi-Wan goes directly to the bar. The bartender hands him a drink. A mean sitting next to him with two antennae holds out something similar to a cigarette.]

Obi Wan: *to bartender* Thank you.

Stranger: You want to buy some death sticks?

[Obi-Wan waves his hand with every sentence he says, using a mind trick on the stranger.]

Obi Wan: You don’t want to sell me death sticks.

Stranger: Oh… uh… I don’t want to sell you death sticks.

Obi Wan: You want to go home and rethink your life.

Stranger: I want to go home and… rethink my life…

[The Stranger walks off to rethink his life. Obi-Wan takes a sip of his drink. Meanwhile, Anakin isn’t having much luck with finding Zam, but he can sense she is close. She happens to be walking towards Obi-Wan, laser pistol in hand. Obi-Wan senses her presence as well. Anakin walks toward the bar, following Zam. When Zam reaches Obi-Wan, she raises her pistol to the back of his head and is about to shoot, when he suddenly ignites his lightsaber, wheels around, and takes off her arm. The crowd hushes instantly. Anakin arrives at the scene.]

Anakin: *to Zam* Easy… *To Crowd* Jedi business. Go back to your drinks.

[The three walk outdoors, Obi-Wan supporting Zam. They set her down on the sidewalk and begin to interrogate her.]

Obi Wan: Do you know who it was that you were tring to kill?

Zam: *weakly* Mmph… It was a senator from Naboo.

Obi Wan: And who hired you?

Zam: It was just a job.

Anakin: *pleadingly* Who hired you? Tell us. *pause* *forcefully* Tell us now!

Zam: *whimpers * It was a bounty hunter called-

[A dart flies out of the air and hits her in the neck. Obi-Wan looks up and sees a person hovering on a jetpack a ways above them, clad in blue and gray armor. He flies away a second later. Her skin begins to shift color and form to a rough green and an inhuman texture and shape. Zam says something in a strange language, and her head falls back. She is dead. Obi-Wan picks up the dart and inspects it.]

Obi Wan: A toxic dart…

[The next day, in the Jedi Temple. The High Council is seated, but Obi-Wan and Anakin remain standing.]

Yoda: Track down this bounty hunter, you must, Obi-Wan.

Windu: Most importantly, find out who he’s working for.

Obi Wan: What about Senator Amidala? She will still need protecting.

Yoda: Handle that, your Padawan will.

Windu: Anakin- escort the Senator back to her home planet of Naboo. She’ll be safer there. And don’t use registered transport. Travel as refugees.

Anakin: As the leader of the opposition, it will be very difficult to get Senator Amidala to leave the capital.

Yoda: Until caught, this killer is, our judgment she must respect.

Windu: Anakin- go to the senate and ask Chancellor Palpatine to speak with her about this matter.

[A little later that day- in the Chancellor’s meeting room again. Anakin and Palpatine are discussing Senator Amidala.]

Palpatine: I will talk with her. Senator Amidala will not refuse an executive order. I know her well enough to assure you of that.

Anakin: Thank you, Your Excellency.

Palpatine: And so... they’ve finally given you an assignment! Your patience has paid off.

Anakin: Your guidance rather my patience.

Palpatine: You don’t need guidance, Anakin. In time, you will learn to trust your feelings. Then you will be invincible. I have said it many times: you are the most gifted Jedi I have ever met.

Anakin: Thank you, Your Excellency.

Palpatine: I see you becoming the greatest of all Jedi… even more powerful than Master Yoda.

[In the Jedi Temple. Windu, Obi-Wan, and Yoda are walking along.]

Obi Wan: I am concerned for my Padawan. He is not ready to be given this assignment.

Yoda: The Council is confident in its decision, Obi-Wan.

Windu: The boy has exceptional skills.

Obi Wan: But he still has much to learn, Master. His abilities have made him, well, arrogant.

Yoda: Yes, yes. A flaw more and more common among

Jedi. Hmm… Too sure of themselves, they are: even the older, more experienced ones.

Windu: Remember, Obi-Wan: if the prophecy is true, your apprentice is the only one who can bring the force back into balance.

[Later on: In Padmé’s temporary home.]

Padmé: I’m taking an extended leave of absence. It will your responsibility to take my place in the senate. Representative Binks, I know I can count on you.

Jar Jar: Mesa honored to be taking on disa heavy burden. Mesa accept dis wit moy moy humility and euh…

Padmé: Jar Jar- I don’t wish to hold you up. I’m sure you have a great deal of work to do.

Jar Jar: Of course… milady.

[Jar Jar walks off, and Padmé walks over to Anakin.]

*/

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
