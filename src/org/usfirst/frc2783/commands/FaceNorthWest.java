package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FaceNorthWest extends Command {

    public FaceNorthWest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.tankDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.tankDrive.setRobotPose(new Bearing(45));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

/*    "A long time ago, in a galaxy far,
far, away . . . . "

A vast sea of stars serves as a backdrop for the main title,
followed by a roll-up, which crawls into infinity.

   EPISODE III:  RISE OF THE SITH

It has been five years since the
Clone Wars began.  Dozens of worlds
have been scarred and thousands of
lives lost.

The Jedi Knights have sustained
terrible casualties as they prepare
for what might be their ultimate
battle with the Confederacy of
Independent Systems at the
strategic planet of Alderaan.

Meanwhile, the mysterious Darth
Sidious schemes to convert Anakin
Skywalker to the dark side as a
weapon against the Jedi . . .

PAN DOWN to a Trade Federation battleship, accompanied by three
huge dreadnoughts and a droid control ship moving through space.


INT. FEDERATION FLAGSHIP - BRIDGE

NUTE GUNRAY and RUNE HAAKO watch an approaching planetary system
on the main viewscreen.  NOONTA GRABUNTING, the grizzled
Neimoidian captain, approaches the viceroy.

            NOONTA
(in Neimoidian) We are entering
Alderaan system, viceroy.

            NUTE
(in Neimoidian) Excellent,
captain, excellent.  Normal
approach channels, we don't want to
alarm them, eh?  Heh, heh, heh,
hehhhh.

He watches the beautiful blue-green planet grow large on the
viewscreen.  Rune Haako nervously rubs his hands together,
shakes his head.

                                                     2.

INT. FEDERATION FLAGSHIP - CABIN

A holographic image of Alderaan floats before a silver-haired
figure brooding in the darkness.  COUNT DOOKU is roused from his
meditation by a hologram of DARTH SIDIOUS.  Dooku bows his head
reverently.

            DOOKU
We have entered the Alderaan
system, my lord.

            DARTH SIDIOUS
Everything is in readiness here.
You know what to do.

Dooku bows his head.  Darth Sidious' evil LAUGHTER and hologram
fade.  Dooku slowly closes his gloved hand around the hologram
of Alderaan, as though he were considering crushing the planet.


EXT. SPACE - ALDERAAN

The sinister armada closes on the planet.


EXT. CORUSCANT - EXECUTIVE QUARTERS BUILDING - DAY

A constant flow of mostly civilian air traffic fills the smoggy
skies above the gleaming city.


INT. BAIL ORGANA'S OFFICE - DAY

The door whooshes open, SUPREME CHANCELLOR PALPATINE enters with
an apologetic smile.

            PALPATINE
My sincerest apologies, ah, I was
unavoidably detained by urgent
matters of state.

YODA, MACE WINDU, OBI-WAN KENOBI, ANAKIN SKYWALKER, PADMé
AMIDALA-SKYWALKER, and BAIL ORGANA rise to their feet as
Palpatine joins them.

            YODA
Mmm, understandable this is,
Chancellor.  Most difficult times
are these, hmn?

            MACE WINDU
Indeed.  What news?


Palpatine sighs, deeply distressed.

                                                     3.

            PALPATINE
Grim, I fear.  Bothan intelligence
agents inform us that the
separatists are preparing to launch
an invasion.

A murmur of dismay sweeps through them.

            PADMé
Do we know where they're going to
strike?

            PALPATINE
Alderaan.

            BAIL ORGANA
But, why?  We've remained neutral.

            PALPATINE
They care little for diplomatic
immunity.  They seek to disrupt and
confound us at every turn.

            MACE WINDU
A successful coup would send a
message that no world is outside
their reach.

            OBI-WAN
I can't believe they have such
callous disregard for the innocent
lives that would be lost.

Anakin stands slightly off by himself, wrapped in his own thoughts.

            BAIL ORGANA
I must return home at once.

PADMéPALPATINE
Is that wise?                    Far too dangerous, Viceroy
                         Organa, if --

            BAIL ORGANA
I appreciate your concern, but that
is my home world.

Palpatine nods his head in resignation.

            YODA
Anything of their strength do we know?

            PALPATINE
A bit.  We suspect Count Dooku is
leading them.

                                                     4.

Anakin's head snaps up.  His face darkens, his mechanical hand
clenches.

            ANAKIN
Dooku . . . !

Obi-Wan glances disapprovingly at him.  Anakin stares back
defiantly, then looks away.  OVER this:

            PALPATINE (OS)
His experience and leadership may
make this rabble a formidable
threat to the peace and safety of
the Republic.

            BAIL ORGANA
I respectfully request a dispatch
of troops at once, Chancellor.

Yoda and Mace Windu exchange a look of foreboding.

            PADMé
Though I'd hoped we could avoid
conflict, I'm forced to agree.  We
don't want a repeat of what
happened on my home world.  Naboo
will support such a move also.

Obi-Wan studies Anakin, trying to sense his feelings.  Anakin
pulls his robes tighter, as though to shield himself from his
mentor.

            PALPATINE
I, too, see no alternative, as much
as it pains me.

            YODA
The Jedi also do I recommend.  If
present Dooku is, too great may his
powers prove otherwise.

They assent.  Mace Windu glances at Obi-Wan, who nods.  Yoda
looks from Obi-Wan to Anakin, thoughtful.


INT. EXECUTIVE QUARTERS BUILDING - CORRIDOR - DAY

Obi-Wan sees Anakin staring through a window, angry.  Air
traffic zooms past outside in a constant flow.  Obi-Wan turns to
find Padmé watching him, concerned, and a little apprehensive.

Obi-Wan stands beside his apprentice.  Anakin doesn't look at him.

                                                     5.

            OBI-WAN
A Jedi does not seek revenge,
Anakin, it is not our way.

Anakin turns on him, but bites back his retort.  He turns
sullenly to the window.

            OBI-WAN
Far too much is at stake, we cannot
afford internal disunity now, my
padawan.

            ANAKIN
Always your padawan.  Will I ever
be a Jedi?

            OBI-WAN
You already are.  I simply --

            ANAKIN
Then treat me like one!  Let me
follow my feelings.  There's only
one way to deal with Dooku.

His stare challenges Obi-Wan to disagree, but Obi-Wan just looks
at him calmly.

            OBI-WAN
We've had this discussion before.
You'd best prepare.  We'll be
leaving shortly.

Anakin doesn't answer.  Obi-Wan, troubled, turns and walks away.
Behind him, Anakin's jaw tightens.


EXT. CORUSCANT - APARTMENT BUILDING - DAY

Immense skyscrapers sprawl over a vast acreage in the diplomatic
sector.


INT. PADME AND ANAKIN'S APARTMENT - DAY

Padmé gazes through the huge window as two military speeders fly
past, bank and disappear.  Anakin moves up behind her, slips his
arms around her waist.  She turns to look into his eyes, they
kiss tenderly.  When they break, she studies him, concerned.

            PADMé
What's wrong, Annie?

He shakes his head, mildly irritated.

                                                     6.

            PADMé
I know something is.  Lately,
you've been so --

            ANAKIN
What?

His angry undertone startles her.  He shakes it off, hugs her
tightly.

            ANAKIN
Ahh . . . I'm sorry, Padmé.  It's
just all this . . .

He shrugs, smiles warmly at her, the old Anakin once again.

            ANAKIN
Sometimes I don't know how you put
up with me.  I just want you to
know . . .

            PADMé
I know.  You and Obi-Wan have so
much to deal with.  I only wish
there were more I could do.

            ANAKIN
You're already doing more than I
want you to.

            PADMé
It's my fight as well.  As a matter
of fact, I was involved long before
you were.

He turns away, angry again.

            ANAKIN
What's that supposed to mean?!  You
think I'm still a child?!  Well I'm
not!

            PADMé
Of course you aren't.  Take it
easy, Annie, I'm not your enemy,
and neither is Obi-Wan.  He's a
friend, a good friend.

She slips into his arms.  His anger dissolves, they kiss gently.
At precisely the wrong moment, C-3PO trundles in.

                                                     7.

            THREEPIO
Master Anakin, yoo-hoo, we're ready
to -- oh!  Oh, my, I'm so sorry.
How clumsy of me, I didn't mean to --

            PADMé
It's all right, Threepio.  We were
just saying our goodbye --

Anakin gently covers her lips with his fingers.

            ANAKIN
Temporary farewells.  Never goodbye.

R2-D2 rolls in, BEEPING and WHISTLING cheerfully.  They both
look at him and laugh.  Anakin kisses her again.

            ANAKIN
This will all be over soon, don't
worry.

He gathers up his things, pauses at the door for a last look and
confident smile, then heads out.  Padmé gazes after him, disturbed.

            THREEPIO
Now you be sure to take good care
of Master Anakin, Artoo.  Even a
Jedi can't be too careful in times
like these.

Artoo BEEPS a cheerful reply, and rolls off after Anakin.

            THREEPIO
Don't be so sure of that.  And you
be careful, too.  You know you're
always getting into trouble when
I'm not around!  Sometimes I don't
know how you managed to --

Artoo BEEPS a curt response as he exits.  Despite his lack of
facial features, Threepio manages to look offended.

            THREEPIO
Well, really!  Some droids can't
even take a bit of constructive
criticism.  Stupid little short-
circuit!  I don't know what he'd do
without me.  Who would be there to --

And so forth as he bustles out.  Padmé hugs herself, repressing
a shiver.

                                                     8.

EXT. SPACE - CORUSCANT

A large fleet of Republic starships, including prototype Star
Destroyers and various starfighters, moves away from the planet.


EXT. CORUSCANT - EXECUTIVE QUARTERS BUILDING - CHANCELLOR'S
OFFICE - BALCONY - DAY

High on one of the giant towers, Palpatine stares up at the tiny
specks twinkling against the smoggy sky.  A slight smile plays
about his lips.


INT. REPUBLIC FLAGSHIP - CAPTAIN'S CABIN

Yoda, Obi-Wan, Bail Organa, Mace Windu and KI-ADI-MUNDI sit at
the command table.  A hologram of Anakin is projected above its
surface.

            ANAKIN
Standing by to jump into hyperspace,
Master Yoda.

            YODA
Careful must you be, young
Skywalker.  Not complete is our
information.  Much yet remains
hidden, and dark portents do I sense.

            ANAKIN
No need to worry, we can handle
anything they throw at us.

The Jedi exchange an amused look at his brashness.  Obi-Wan
sighs and shakes his head.

            MACE WINDU
Your starfighters will engage any
Trade Federation droid fighters.

            OBI-WAN
Viceroy Organa and I will coordinate
ground forces.

            BAIL ORGANA
Captain Rieekan assures me that
they're assembled and ready.

            KI-ADI-MUNDI
This disturbs me greatly, it's too
blatant and foolhardy.  The Sith
are not this reckless.

                                                     9.

            OBI-WAN
We've been unable to counter them,
perhaps they've grown overconfident.

            MACE WINDU
Hopefully, we can use that to our
advantage.

            YODA
Nothing for granted must we take.
Strong and invasive is the dark
side in this, and still know we not
the identity of this Sith master.

            OBI-WAN
Who always seems to be one step
ahead of us . . . as if he knew
what we were planning to do before
we did it.


INT. ANAKIN'S STARFIGHTER - COCKPIT - MOVING

Anakin smiles confidently.

            ANAKIN
Not this time.  They won't know
what hit them.

A hologram of Yoda atop the control console nods grimly.

            YODA
Then, may the Force be with you.

            ANAKIN
May the Force be with you, Master.

Yoda's hologram fades.  In the navigation module, Artoo monitors
the ship's systems, BEEPING fretfully.

            ANAKIN
Relax, Artoo, this time we have all
the advantages.  Besides, you and I
make quite a team.

Artoo BEEPS a string of worried queries.

            ANAKIN
Trust me, I can feel --

He stops as a strange feeling washes over him . . . he shivers
involuntarily, entranced.  Artoo BEEPS, worried.  Anakin shakes
himself free with an effort.

                                                    10.

            ANAKIN
(into commlink) All units --
prepare to jump.


INT. INTERCUT - VARIOUS COCKPITS

Grim pilots, Naboo and Corellian, ready their instruments.


EXT. SPACE

The fleet begins to converge.

            ANAKIN (VO)
On my mark . . . jump!

They BLAST into hyperspace in an awesome display!


EXT. SPACE - ALDERAAN

Trade Federation ships orbit the moonless planet, creating a
blockade.


INT. FEDERATION FLAGSHIP - BRIDGE

Nute Gunray surveys the frenetic activity calmly from his
walking chair.  Beside him, Rune Haako paces, worried as usual.
Suddenly, bridge ALARMS begin to flash --

            NOONTA
Here they come -- !

Nute and Rune strain toward the main viewscreen.


EXT. SPACE - ALDERAAN

The Republic fleet appears with a ROAR!  Trade Federation
battleships move toward them.


INT. FEDERATION FLAGSHIP - BRIDGE

Nute Gunray draws in a shocked breath, Rune Haako trembles.

            RUNE
Th-there's so many of them . . .

                                                    11.

            NUTE
It will make no difference!
Captain Grabunting -- order all
vessels to engage!


EXT. SPACE - ALDERAAN

The two fleets close the distance.


INT. REPUBLIC FLAGSHIP - BRIDGE - MAIN CONTROL DECK

Yoda sits in the command chair, surrounded by Jedi in distinctive
battle dress.  His eyes narrow as he watches the Trade Federation
ships approach.


INT. REPUBLIC FLAGSHIP - DOCKING BAY

Dooku pauses in the act of boarding a small one-man lander.  He
smiles grimly, sensing Yoda's presence.  He enters the lander,
the armored cockpit lowers into place with a CLICK.


EXT. SPACE - ALDERAAN

Trade Federation warships deploy hundreds of droid starfighters.
Fifty troop landers streak toward the surface, Dooku's lander
nestled among them.


INT. REPUBLIC FLAGSHIP - BRIDGE - MAIN CONTROL DECK

Yoda turns, nods at the tense CAPTAIN RIEEKAN.


EXT. SPACE - ALDERAAN

Jedi starfighters and TIE interceptors streak out of the Star
Destroyers.  Space is lit by flashes and EXPLOSIONS as the
battle is joined.

From the planet's far side twenty Federation battleships emerge,
lasers and ion cannons firing.


INT. REPUBLIC FLAGSHIP - BRIDGE

Yoda notes the new arrivals with little surprise.

            YODA
(into commlink) All forces . . .
engage.

                                                    12.

EXT. SPACE - ALDERAAN

Deadly laser bolts streak through space.  EXPLOSIONS erupt on
the large ships on both sides.  Jedi, TIE and droid starfighters
battle fiercely with each other.


INT. REPUBLIC FLAGSHIP - BRIDGE

Nute Gunray watches raptly, Rune Haako wrings his bony hands in
despair.

            RUNE
This will end badly for the
Federation, I fear.

            NUTE
Will you cease your pathetic
sniveling!?  I'm trying to enjoy this!

            RUNE
We should never have agreed to this!
The Sith are mad!  It will be our
ruin!  Viceroy, I implore you --

            NUTE
Silence!  Another word, and I will
inform Lord Sidious of your
treacherous mutterings!

Rune subsides reluctantly, trembling.


EXT. SPACE - ALDERAAN

The two fleets pound each other mercilessly.  Smaller ships on
both sides EXPLODE.  Anakin leads twenty starfighters toward a
Federation battleship, weapons firing.


INT. ANAKIN'S STARFIGHTER - COCKPIT - MOVING

He guides his ship past a swarm of droidships, blowing up
several.  He zooms through an expanding fireball.

            ANAKIN
Silver wing form up on me, we're
going after the flagship.


INT. XAN COSTA'S STARFIGHTER - COCKPIT - MOVING

He's a grizzled Corellian with a battered optical device over
one eye.

                                                    13.

            COSTA
Aye, they'll be expectin' that.


INT. ANAKIN'S STARFIGHTER - COCKPIT - MOVING

He allows himself a tight smile, clenching his mechanical hand.

            ANAKIN
I know.  I have a debt to repay.


EXT. SPACE - ALDERAAN

They blast through the droid ships, and hurtle toward the
Federation's flagship.  The flagship's guns blaze at them, but
they're too small and maneuverable.


INT. REPUBLIC FLAGSHIP - BRIDGE

Captain Rieekan turns from his console to Yoda.

            RIEEKAN
We've picked up a new group of
signals, headed for the planet.
Shall we engage?

            YODA
Foreseen this contingent was.
(into commlink) Obi-Wan . . .


EXT. ALDERAAN - SAVANNAH - DAY

Gently swaying grasslands and prairies stretch in all directions,
a sea of vari-colored grass.  Nearby is a small city, designed
to blend harmoniously with the natural habitat.

Obi-Wan stands atop a large many-domed fortress, its color
flowing in a gradient from the green of the plains to the deep
blue of the sky, with Bail Organa and twenty GENERALS.  Yoda's
hologram flickers before them.

            YODA
Troop transports have they
dispatched to the surface.


INT. ANAKIN'S STARFIGHTER - COCKPIT - MOVING

He blasts a droid fighter into cosmic dust.

                                                    14.

            YODA (VO)
(on commlink) Count Dooku, I
believe, accompanies them.

Anakin reacts.  He re-adjusts his course.


EXT. SPACE - ALDERAAN

Anakin's starfighter breaks away from the battle and streaks
toward the planet.


EXT. ALDERAAN - SAVANNAH - DAY

            OBI-WAN
Understood.  We'll be ready.

He turns to the anxious Generals, they salute, hurry off.  Bail
Organa glances nervously at Obi-Wan, who stares grimly towards
the plains below.


EXT. ALDERAAN SKIES - DAY

Federation troop ships descend rapidly through the fleecy
clouds, surrounding Dooku's lander.


INT. DOOKU'S LANDER - DAY - MOVING

Around him, troop ships open their launch bays.

            BATTLE DROID (VO)
(over commlink) Troops ready for
deployment, sir.

            DOOKU
Launch!


EXT. ALDERAAN SKIES - DAY

Hundreds of AIR-BORNE BATTLE DROIDS, their jet-packs flaring,
streak downward like meteors from the troopships.


EXT. ALDERAAN - SAVANNAH - FORTRESS - DAY

Obi-Wan looks up sharply, grabs his electrobinoculars, focuses
them upward.

Through them he sees hundreds of aerial battle droids streaking
toward them.

                                                    15.

He lowers the electrobinoculars, his jaw tightening.  Bail
Organa sees them approaching, and looks stricken.


EXT. SPACE - ALDERAAN

A Federation battleship is strafed by dozens of Republic
starfighters.  EXPLOSIONS erupt along its surface.


INT. XAN COSTA'S STARFIGHTER - COCKPIT - MOVING

He pumps his fists in the air as the battleship begins to drift,
disabled.  The CHEERS of other PILOTS fill the comm system.


EXT. SPACE - ALDERAAN

Twenty Republic troopships, smaller and more maneuverable than
the Federation ships, streak toward the surface.


INT. REPUBLIC TROOPSHIP - MAIN BAY

Mace Windu, Ki-Adi-Mundi, EETH KOTH, ADI GALLIA, and hundreds of
CLONE WARRIORS stand ready in the huge staging bay.  SIV KHANO,
a young, red-skinned blue-haired Jedi turns from the controls.

            SIV KHANO
They've dispatched several fighters
after us, Master.

            MACE WINDU
Stay on course.  It's taken care of.


EXT. SPACE - ALDERAAN

Jedi and Correlian starships engage the Federation fighters.
Ships on both sides EXPLODE.


EXT. ALDERAAN - SAVANAH - FORTRESS - DAY

The air-borne battle droids appear in the sky.

            OBI-WAN
Take cover!

They duck behind battlements as the air-droids zoom past
overhead firing laser bolts that EXPLODE chunks out of the
fortress.

                                                    16.

            OBI-WAN
Stay down!  They'll come around for
another pass!

Bail Organa has a commlink in his hand.

            BAIL ORGANA
They're falling all around the city!
We're surrounded!

They peer over the battlements.


EXT. ALDERAAN - SAVANAH - DAY

Herds of Nerfs and Grazers flee before a huge army of BATTLE
DROIDS that marches across the sculpted landscape.  Behind them
roll massive ion cannons and large floating assault weaponry.
More landers touch down and discharge their droid cargo.


EXT. ALDERAAN - SAVANNAH - FORTRESS - DAY

Obi-Wan, Bail Organa and a dozen Generals watch through
electrobinoculars.  Overhead, small one-man scout ships speed
past them headed toward the assault force.


EXT. ALDERAAN - SAVANAH - DAY

Battle droids march toward the city.  The scout ships streak
down on them, firing.  An EXPLOSION hurls droids in all
directions!  They immediately go into battle mode, their firing
at the scout ships.

Fifty SUPER BATTLE DROIDS roll through the ranks toward the
front lines and assume battle configuration.  As they advance,
Republic attack gunships full of Clone Troopers swoop over the
hill.

They blast scores of battle droids on their first pass.  The
Federation's giant ion cannons fire after them as they streak
away, and BLAST several out of the air.  The crash to the
ground, EXPLODING.

EXPLOSIONS target the ion cannons' shields.  Twenty SPHA-T
walkers stride over the crest of a hill, blasting droids.
Alderaan TROOPS follow them, and take up positions, firing
bazooka-like weapons.

                                                    17.

INT. DOOKU'S COMMAND WALKER - DAY - MOVING

Dooku watches the assault, amused.  Laser bolts streak past, and
EXPLOSIONS detonate around him, shaking the walker slightly.


EXT. ALDERAAN - SAVANNAH - DAY

EXPLOSIONS everywhere!  SPHA-Ts pound the droids.  Alderaan
troops advance behind them, firing heavy-lasers.  It's an
inferno of EXPLOSIONS, streaking missiles, and laser fire.

Air-borne battle droids swoop in, cutting down Alderaan troops
in a deadly hail of laserfire as they overfly the field.
Several of them dogfight with the scout ships.


EXT. ALDERAAN - SAVANNAH - FORTRESS - DAY

Obi-Wan leaps up and hacks an air-borne battle droid in half
with his lightsaber.  He lands on a battlement, deflecting
laserbolts as several more swing toward him.

Bail Organa and the Generals fire heavy-blasters, taking out a
dozen air-droids.  Several Generals also fall.


EXT. SPACE - ALDERAAN

The Federation's battlecruisers are pounded by the Star
Destroyers.  One ship EXPLODES, the others are racked by lasers
and photon torpedos.


INT. FEDERATION FLAGSHIP - BRIDGE

The crew's in a panic.  ALARMS go off, emergency bulkheads SLAM
shut, consoles EXPLODE and spark.  Rune Haako looks around in
terror.

            RUNE
We're doomed!  DOOMED!!!  I told
you --

            NUTE
Blind me, where are our
reinforcements?!  Lord Sidious
promised us --

            NOONTA
They aren't coming!  We've been
betrayed!

                                                    18.

            NUTE
Pull us out of here -- pull us --


EXT. SPACE - FEDERATION FLAGSHIP

A direct hit on her bridge superstructure causes a chain
reaction of several large EXPLOSIONS!


INT. FEDERATION FLAGSHIP - BRIDGE

Nute Gunray is shredded by shrapnel.

            NUTE
YAAAAAHHHHH --!

The bridge begins to depressurize.  Rune Haako covers his head
and flees toward the elevators.


EXT. SPACE - BATTLE

EXPLOSIONS dot the surface of the Federation flagship.  A nearby
Star Destroyer suffers several EXPLOSIONS.  Federation
battleships turn about and attempt to escape.


INT. REPUBLIC FLAGSHIP - BRIDGE - MAIN CONTROL DECK

            YODA
With them must you stay!  No escape
must there be.

Captain Rieekan nods grimly and bends over a bridge crewman's
station.


EXT. SPACE - ALDERAAN

Federation battleships are pursued by the Star Destroyers.
Droid starfighters battle the Republic's ships.


EXT. ALDERAAN - SAVANNAH - DAY

EXPLOSIONS claim droids and Soldiers.  A BATTLE WALKER moves
through the field, blasting the Alderaan soldiers.  Air-droids
streak down, killing more of them.

                                                    19.

INT. DOOKU'S COMMAND WALKER - DAY - MOVING

Dooku watches the battle.  An EXPLOSION on the hull rocks him --
he sits upright, alarmed.


EXT. ALDERAAN - SAVANNAH - DAY

A thousand Clone Troopers sweep out of troop carriers, their
weapons blazing.  Hundreds more pour down from the surrounding
hills.  The droids are surrounded and outnumbered.

Obi-Wan leads a hundred Clone Troopers and Jedi out of the citadel.

            OBI-WAN
Now!

Republic troopships touch down in a blast of retros, discharging
hundreds more Troopers and Jedi.  They charge into the droids.
Lightsabers flash -- lasers streak -- droids EXPLODE with
electronic SCREAMS!  Troopers blast everything in their path
with cold-blooded efficiency.

Obi-Wan and dozens of Troopers and Jedi attack the droids from
the flank.  His lightsaber slices through battle droids.

SPAH-T walkers stride through droids, blasting them to shrapnel.
The ion cannons are targeted -- their shields flicker and fail.
They EXPLODE.

Air-borne battle droids streak in, blasting Clones and Jedi,
stopping them momentarily.  Anakin's starfighter and three
others hurtle past, blasting the air-droids.  Obi-Wan looks up,
shakes his head, smiling.

            OBI-WAN
That boy never could follow
instructions.

He returns to the fight.


INT. DOOKU'S COMMAND WALKER - DAY

Dooku watches the rout calmly, as though he were expecting it.
He leans over the controls.


EXT. ALDERAAN - SAVANNAH - DAY

Dooku's walker blasts several rows of battle droids.  It turns
and strides toward his Geonosian solar sailer.

                                                    20.

EXT. ALDERAAN - SAVANNAH - DOOKU'S SHIP - DAY

Dooku emerges from the walker and heads for his ship.  He stops,
shakes his head, amused.  Ki-Adi-Mundi bars his way, his
lightsaber activated.  Dooku glares contemptuously as the Jedi
Master advances.

            KI-ADI-MUNDI
You have disgraced the Jedi.

            DOOKU
Don't flatter yourselves.

He gestures and Four Super Battle Droids appear, firing.  Ki-
Adi-Mundi deflects their deadly bolts, and leaps to attack.

Dooku watches, smiling . . .

Ki-Adi-Mundi slices through weapons, deflects laser bolts back
into the droids.  As he straightens up after felling the last --

Dooku's lightsaber erupts from his chest!  The Jedi gasps in
pain as Dooku twists the weapon with malicious glee.  Ki-Adi-
Mundi falls, and Dooku strides toward his sailship.


EXT. ALDERAAN SKIES - DAY

Jedi starfighters blast air-borne battle droids above the plains.
Several droids plummet, trailing smoke and flame.


INT. ANAKIN'S STARFIGHTER - COCKPIT - DAY - MOVING

He looks up and his face darkens with rage.


EXT. ALDERAAN SKIES - DAY

Dooku's solar sailer rises from the smoke-strewn surface,
accompanied by two graceful, bird-like Geonosian starfighters.


INT. ANAKIN'S STARFIGHTER - COCKPIT - DAY - MOVING

Enraged, he sets off in pursuit.


EXT. ALDERAAN SKIES - DAY

Anakin's starfighter streaks after Dooku's ship.

                                                    21.

INT. DOOKU'S SHIP - COCKPIT - DAY - MOVING

He coldly eyes a hologram of the cringing Noonta Grabunting.

            NOONTA
You must help us, we've been routed!
The Jedi --

            DOOKU
Yes, my friend, as they were meant to.

            NOONTA
Whuh-what -- what do you --

Dooku activates a control . . .


EXT. SPACE - ALDERAAN

Federation battleships erupt in massive fireballs!


INT. REPUBLIC FLAGSHIP - BRIDGE - MAIN CONTROL DECK

Yoda and the others react with surprise as their quarry EXPLODES.

            RIEEKAN
Back us off -- back us off!

Yoda's eyes narrow.


INT. ESCAPE POD - MOVING

Rune Haako cries out in despair, holding his head as he sees the
massive ships destroyed.


EXT. SPACE - ALDERAAN

The tiny pod hurtles toward Alderaan.  Several other escape pods
float through the starry sky.


INT. DOOKU'S SHIP - COCKPIT - DAY - MOVING

His ship's rocked by a BLAST, laserbolts flash past.  He glances
at his screen, which shows Anakin's starfighter closing on him.
Dooku activates one of his controls.

                                                    22.

EXT. ALDERAAN SKIES - DAY

The Geonosian ships bank around and hurtle at Anakin's ship,
firing.


INT. ANAKIN'S STARFIGHTER - COCKPIT - DAY - MOVING

Artoo BEEPS with concern as multiple hits shake the ship.
Anakin struggles with the controls as his systems short out.


EXT. ALDERAAN SKIES - DAY

Dooku's ship rises toward the clouds.  Anakin's ship's engines
are hit, and he streaks toward the surface, trailing plumes of
smoke and flame.


INT. ANAKIN'S STARFIGHTER - COCKPIT - DAY - MOVING

He glares after Dooku's disappearing ship.  Artoo BEEPS
frantically, his dome swiveling.  Flame retardant sprays out of
several of his openings, as consoles spark and erupt around him.


EXT. ALDERAAN SKIES - DAY

The Genosian ships streak into the clouds as Anakin's ship
hurtles toward the surface trailing smoke and flames.


INT. ANAKIN'S STARFIGHTER - COCKPIT - DAY - MOVING

Anakin coughs, smoke filling the cockpit of his shuddering ship.
Artoo BEEPS frantically, trying to re-establish control of the
ship's systems.  Anakin's focused on fighting the malfunctioning
controls, to no avail.


EXT. ALDERAAN SKIES - DAY

Anakin's ship hurtles toward the ground like a meteor.


INT. ANAKIN'S STARFIGHTER - COCKPIT - DAY - MOVING

He wrestles the controls, furious.  Out of his cracked cockpit
he sees the ground rushing up.  Artoo SCREECHES in panic.
Suddenly, Anakin's tortured face relaxes.

            DARTH SIDIOUS (VO)
You must use your anger, my young
jedi.  It will help you to survive!

                                                    23.

A powerful force ripples through him, he shakes and sweats,
confused.  Artoo BEEPS and WHISTLES frantically.  Slowly, Anakin
reaches toward the controls.  A strange power flows from him
into the ship.  With a jolt --


EXT. ALDERAAN - SAVANNAH - DAY

-- the ship ceases its plunge and glides to a rough landing.  It
skids across the grass --


INT. ANAKIN'S STARFIGHTER - COCKPIT - DAY - MOVING

Anakin holds onto the controls, the strange power flowing from
his hands into the ship.  Artoo's NOISES change from terror to
wonder.


EXT. ALDERAAN - SAVANNAH - DAY

Anakin's ship skids to a stop against a tall, exotic tree,
smoking and leaving a long furrow in the ground.  The canopy
ejects and Anakin stumbles out, coughing and shaken.  Artoo
follows, BEEPING in confusion.

Anakin falls to his knees, gasping and coughing.  He looks
toward the sky, trembling, a dawning wildness in his eyes.


EXT. ALDERAAN - SAVANNAH - DAY

Surviving droids attempt to surrender, but Clone Troopers
destroy them mercilessly.

On a nearby hillock, Obi-Wan and Mace Windu stand over Ki-Adi-
Mundi's body, surrounded by the smoking remains of the Super
Battle Droids.


INT. JEDI HALL OF ASCENSION - DAY

Ki-Adi-Mundi lies in state in the huge hall, illuminated by
sunbeams streaking through the towering windows, surrounded by a
Jedi honor guard.

The huge hall is full of Jedi, padawans, apprentices and heads
of state.  Among them:  Palpatine, Padmé, JAR JAR BINKS, Bail
Organa, Artoo and Threepio.

            THREEPIO
Oh, dear, oh, dear, how awful.
These are indeed perilous times, my
obtuse friend.

                                                    24.

Artoo BEEPS solemnly in agreement.

Yoda, Mace Windu, Obi-Wan, Adi Gallia and Eeth Koth kneel with
other Jedi beside the glass sarcophagus.  As they rise, Bail
Organa, Palpatine and Padmé move up beside them.

            PALPATINE
We grieve with you.

            PADMé
Yes.  His death diminishes us all,
even as his valor ennobled us.

            YODA
Thank you.  Not the end is death to
a Jedi, always will he be with us.

They move slowly away as dignitaries file past the body to pay
last respects.  Padmé glances around the great hall.

            PADMé
Where's Anakin?  He didn't return
with you?

            OBI-WAN
He's helping to supervise the
disarmament of the separatists.

Bail Organa scowls.

            BAIL ORGANA
What will be done with them?

            PALPATINE
Temporary detention camps are being

set up.  Afterwards, we'll see what
can be done to reconcile our
differences, perhaps in time . . .

Bail Organa looks away.  It's obvious he doesn't agree with this
solution.


EXT. JEDI TEMPLE - MEDITATION GARDEN - EVENING

Obi-Wan and Yoda stroll past varieties of exotic flowers, zen-
like fountains where several Jedi meditate in alcoves.  Yoda
pokes thoughtfully at a new flower bed with his walking stick.

            YODA
Mmm.  Soon, will emerge new life, a
beginning and a continuation.
Always has this been the way of the
Force . . . of all things.

                                                    25.

Obi-Wan looks around sadly.

            OBI-WAN
Ki-Adi-Mundi always liked this,
because it was so unlike his home.
Somehow . . . I can't help feeling
as if we've grown more vulnerable.
Our ability to use the Force is
greatly diminished.

            YODA
Mmm.  All around us spreads the
darkness.  Into everything it
seeps, our hearts, our spirits . . .
even fear have I begun to sense
among the younger Jedi.

            OBI-WAN
I have felt it also.  It seems to
become stronger by the hour.

He sits down wearily.  Yoda puts a hand on Obi-Wan's shoulder.

            YODA
To this must you not succumb, Obi-
Wan.  Though dark and uncertain is
our future, the light must not go out.

Obi-Wan nods, drawing a little strength from Yoda's conviction.
Yoda looks up at the starry sky, sighing.

Threepio and Artoo look down from a shaded walk.  Artoo BEEPS
plaintively.  Threepio nods in commiseration.

            THREEPIO
Indeed, it appears that even in
victory, there's little to celebrate.


EXT. CORUSCANT - EXECUTIVE QUARTERS BUILDING - DAY


Mixed with the air traffic are a large number of military
speeders.  Late afternoon sunlight is dimmed by the smoggy
skies, creating a feeling of gathering gloom.


INT. CHANCELLOR'S OFFICES - DAY

Palpatine gazes through the huge balcony window.  Behind him,
LOTT DOD and Rune Haako sit nervously before his desk.

                                                    26.

            RUNE
. . . and I, I do not know what to
do, Chancellor.  A-all seems to be
lost, if not for your influence --

Palpatine smiles slightly, his back turned to them.

            PALPATINE
Your Viceroy's death, I fear,
leaves you little choice.  You must
sign the treaty, disband the droid
armies, and end your control over
the Federation.

The Neimoidians look at each other, stunned.

            RUNE
B-but -- but that's --

            LOTT DOD
Preposterous!  You cannot dictate
policy to us!  Count Dooku is the
separatist leader.  Why should we --

            PALPATINE
Nevertheless, you will have to
accept the fact that the Federation
has outlived its usefulness.

            NUTE GUNRAY
But -- but -- what of our interests?
We were promised certain --

Palpatine cuts him off with an impatient wave.  Lott Dod rises
angrily to his feet.

            LOTT DOD
Never!  Never, I say!  We will not --

He stops, confused, grabs at his throat, his eyes bulging.  He
gasps for breath as Palpatine turns slowly, smiling.  Rune
watches in horror as Lott Dod trembles violently, choking, and
falls to the floor, dead.  Rune looks at Palpatine fearfully as
two red-clad ROYAL GUARDS enter.

            PALPATINE
The ambassador will be staying with
us for a time.  See to his
accommodations.

Rune cringes as the Guards pull him to his feet, drag him from
the room.

                                                    27.

            RUNE
Wait -- wait -- Chancellor --
wait -- please -- !

Palpatine's smile widens as the doors shut.


EXT. SENATE BUILDING - DAY

The towering edifice is bathed in the late afternoon suns.

            PALPATINE (VO)
At long last, the terrible ordeal
we have faced as a people is over.


INT. SENATE CHAMBER - DAY

The vast rotunda is packed, floating platforms hover everywhere.
Palpatine is atop the towering central pinnacle, attended by UV
GIZEN, two AIDES and four Red Guards.

            PALPATINE
The Clone Wars have come to an end.

Stunned silence is broken by THUNDEROUS APPLAUSE as all the
delegates rise to their feet.  Palpatine basks in the adulation.

Padmé and Jar Jar share a platform, hug each other as Senators
celebrate around them.

            BAIL ORGANA
That is good news!  Now we can
disband the Clone Army --

            PALPATINE
Oh, I do not think that would be
wise at this juncture, Viceroy.

Padmé looks at him in surprise as a MURMUR ripples through the
huge arena.

            BAIL ORGANA
With the conflict ended, there's no
further need --

            PALPATINE
The Jedi have suffered terrible
losses.  During the time of
transition, there must be some way
of maintaining order, must there not?

The assembly MURMURS as this is discussed.  Padmé and Jar Jar
exchange a doubtful look.

                                                    28.

            BAIL ORGANA
With all due respect, Chancellor, I
thought it had been agreed --

            PALPATINE
The Clones will be used solely to
maintain the peace, I assure you.
This is a dangerous time for the
Republic.  It is vital at this
juncture to remain ready to deal
with any eventuality.

            PADMé
Sir, perhaps aided by volunteers,
the Jedi could --

DARSANA, the Ambassador of Glee Anselem moves his pod to the
center of the arena.

            DARSANA
The Jedi have been unable to
contain the separatists so far!
Why should we believe they will
fare differently in the future?!

ASK AAK, the Senator from Malastare, moves his pod up beside
Organa's and Padmé's.

            ASK AAK
Yes!  We must not lose sight of the
fact that we are still vulnerable
to the enemies of the Republic!

Padmé leans back uneasily as the Senators argue back and forth,
and whispers to Jar Jar.

            PADMé
I don't like this.  They're not
listening to reason.

            JAR JAR
Mmm-hm.  Disen no smellen berry
bombad good.

Padmé watches Palpatine closely, disturbed.

SENATOR ORN FREE TAA swings to the fore in his pod.

            ORN FREE TAA
What of the Federation?!  What is
being done about them?!

More SHOUTING as Palpatine holds up a hand for control.  Mas
Amedda tries to restore order.

                                                    29.

            MAS AMEDDA
Order!  Order!

The uproar subsides reluctantly.

            PALPATINE
The Neimoidians have relinquished
their control, and permanently
dismantled the droid armies.

            PADMé
I find it difficult to believe they
would do that willingly.

            PALPATINE
After the debacle on Alderaan,
their power base was broken.  I
promise you, Senator, all those
that were involved in the Naboo
invasion will be brought summarily
to trial.  They will answer for
their heinous crimes.

            PADMé
It's been so long, surely they --
ohhh --

She suddenly reels dizzily.  Jar Jar barely catches her before
she topples off the platform.

            JAR JAR
Oyee-boyee!  Padmé!  Padmé!

She looks up at him woozily as several platforms move toward them.

On his pinnacle, Palpatine stares across at her.


EXT. CORELLIA - DETENTION CENTER - DAY

Military speeders fly through the air, manned by Troopers.
Hundreds of civilians are herded into compounds, and force-
fields are turned on.  Anakin watches, troubled.  He looks up
toward a nearby commotion.

Angry citizens argue with Troopers.  A Trooper roughly shoves a
citizen to the ground.

            CLONE TROOPER
Disperse immediately, or you will
be taken into custody.  This is
your only warning.

                                                    30.

Anakin watches Troopers drive civilians away roughly.  He turns
toward the compound.  Dozens of accusing eyes stare at him from
behind the force-fields.  He turns away.


INT. PADMé'S SENATE CHAMBER - DAY

Padmé lies in a bed, impatient, as a medical droid examines her.
She's surrounded by Jar Jar; CAPTAIN TYPHO, her security
officer; DORMé, her handmaid/bodyguard; Threepio and Artoo.

            PADMé
This really isn't --

            TYPHO
Just relax, Senator, we'll be done
in a moment.  As chief of security,
I must insist.

She subsides reluctantly, the Med Droid continues scanning.

            JAR JAR
Oyee-boyee, yousen frighten the
spookas outen us, Padmé.

The Med Droid finishes its examination.  Captain Typho and Dormé
stop her from getting up.

            TYPHO
Just relax, Senator.  Is there
anything we --

            PADMé
No . . . no, I'm just --

            THREEPIO
Well, speaking on behalf of Artoo
and myself, I must say it's good to
see you fully functional again.

            PADMé
Please, don't worry about me.  I'm
sure it's nothing.

            TYPHO
Well, perhaps you should remain
here for a few hours, get some rest.
I have some security matters to
attend to, but Dormé can --

            PADMé
I'm fine, Captain.  Thank you for
your concern.

                                                    31.

He looks doubtful, but nods and exits.  Dormé pours something
from a pitcher, and Padmé sips some.  She smiles at her
handmaid/bodyguard's worried expression.

            DORMé
I think you should take Captain
Typho's advice, M'lady.

            JAR JAR
Mesa seconden dat.

            THREEPIO
Oh, here, here.  I heartily concur.

Obi-Wan enters, concerned.  He relaxes somewhat when he sees
that Padmé's okay.

            OBI-WAN
You had me worried.  How are you
feeling?

She nods, glances at Dormé.  The handmaid bows, and indicates to
Jar Jar and the droids to follow her.  They leave.  Obi-Wan
settles down, waiting.  After a moment, Padmé looks up at him.

            PADMé
Do you have to look so all-knowing?

            OBI-WAN
Actually, I only sense a curious
mixture of distress and happiness.
I'm not sure what to make of it.

She smiles shyly.

            OBI-WAN
Did the test reveal anything?

            PADMé
Nothing I didn't already know.  I'm
. . . pregnant.

He reacts, stunned.

            OBI-WAN
Oh . . . ?  I had no . . .

He looks at her closely, waiting.  She looks away, takes a deep
breath and plunges in.

            PADMé
Anakin and I are married.

                                                    32.

            OBI-WAN
I see.

He moves toward the window, pensive.  She watches him.

            OBI-WAN
I sensed there was something he was
keeping from me.  That boy is
always so reckless.

He turns toward her, sighs.

            OBI-WAN
Still, what's done is done.  I
suppose congratulations are in order.

            PADMé
Is that how you really feel?

            OBI-WAN
You both know our code . . . a Jedi
shall not know anger, nor hatred,
nor love.  The Council will not be
pleased.

            PADMé
You'll intervene for him, won't you?

            OBI-WAN
I really don't know what I --

            PADMé
They'll listen to you.  Don't let
them punish him, Obi-Wan, it isn't
his fault --

Obi-Wan comes over to sit on the edge of her bed.

            OBI-WAN
It isn't just a matter of fault,
Padmé.   There are reasons for
everything that we do.  We may not
always agree with them, but we are
bound to uphold them.

            PADMé
Then you don't disapprove?

            OBI-WAN
How could I?

She hugs him tightly.  Obi-Wan's happy for them, but he knows
there will be repercussions.

                                                    33.

            OBI-WAN
Does Anakin know?

            PADMé
No.  He's had so much to deal with .
. . I didn't want to cause him any

more problems.

            OBI-WAN
I'm not entirely sure I follow that
logic.  He will have to be told.

            PADMé
I know, but --

Palpatine enters, smiling solicitously.

            PALPATINE
My dear Senator Amidala -- Padmé!
I came as soon as I could get away.
How are you --

            PADMé
It's nothing, Chancellor.  I've
just been . . . working a bit too
hard.

            OBI-WAN
She's been admonished to take
better care of herself.

            PALPATINE
You simply must, my dear.  I have a
feeling you will be an integral
part of our future.

Padmé and Obi-Wan exchange a quick glance.


EXT. CORUSCANT - ROOFTOP LANDING PLATFORM - SUNSET

Against a colorful sunset atop a massive skyscraper, Threepio
and Artoo move among the human and alien throngs coming and
going from air taxis and other transports.

            THREEPIO
Yes, well, I'm afraid it's a bit
more complicated than that, you know.

Artoo BEEPS an innocent question.

                                                    34.

            THREEPIO
Well, no, that is, not exactly.
Humans and machines originate
quite, er, differently, you see.

Artoo BEEPS another query.  Threepio's ruffled.

            THREEPIO
No, I do not care to go into
greater detail, thank you.  If
you're that curious, consult the
city's information banks.

Artoo BEEPS skeptically.  Threepio stiffens.

            THREEPIO
Well -- really!  I do too -- I'm
just not going to tell you!

They move toward Obi-Wan, who waits by a railing overlooking the
metal and glass canyons.  Anakin emerges from a large transport
among other passengers, human and alien.  He looks grim and tired.

            OBI-WAN
Welcome back.  How did it go?

Anakin shrugs, evasive.

            ANAKIN
All right.  No problems.

They start to walk, the two droids following behind them.

            ANAKIN
Have you seen Padmé?  I tried to
reach her, but they said --

            OBI-WAN
The Council knows about your marriage.

Anakin stops.  He glares at Obi-Wan.

OBI-WAN                          ANAKIN
Padmé told me --                And you told them!

            OBI-WAN
Use your head!  You know I had no
choice.

Anakin controls his anger with difficulty.

            ANAKIN
What happens now?

                                                    35.

            OBI-WAN
I honestly don't know.  But you
will have some explaining to do.  I
suggest --

Anakin pulls his cloak around himself, stalks off.  Obi-Wan
follows.  Threepio and Artoo watch, fascinated.


EXT. JEDI TEMPLE - NIGHT

Its tall spires rise up on a vast plain beneath the cloudy skies.

            YODA (VO)
Thought you to keep this hidden
from us, Anakin Skywalker?


INT. COUNCIL CHAMBER - NIGHT

Anakin stands in the center of the room, before the Council who
sit in a circle facing him.  Obi-Wan stands nearby, uncomfortable.

            MACE WINDU
This is a direct violation of our
code.

            ANAKIN
I know that.

            PLO KOON
Then why did you undertake such a
union?

            ANAKIN
Because I love her.

The Council stares at him speculatively, he stares back
defiantly.  Obi-Wan steps forward.

            OBI-WAN
I remind the council that Anakin
came here of his own free will.

            YODA
Mmm.  Which excuses not his
transgression.

Anakin bristles, but Obi-Wan's hand on his shoulder restrains him.

            YODA
To this much thought must be given.
A decision will we make soon.

                                                    36.

            MACE WINDU
Until then, we must place
restriction upon you, Anakin
Skywalker.  You --

            ANAKIN
What?!  Why??!

            OBI-WAN
Anakin --

            ANAKIN
That's -- you're acting like I'm a
common --

            YODA
Silence, young one!

His command rocks Anakin.  Yoda stares hard at him, his normally
calm features tight with displeasure.

            YODA
Not your place is it to question
our motives!  As Master Windu has
spoken, so shall it be.  And warn
you, I do, to take no further rash
actions.

They rise and file out leaving Anakin seething.  Obi-Wan puts a
hand on his arm, but Anakin shakes it off.

            ANAKIN
Thanks for coming to my defense.

            OBI-WAN
You know as well as I, there was
nothing I could do.  This affair --

            ANAKIN
Why don't you just admit it?!  You
want this to happen.

            OBI-WAN
Don't be ridiculous, why --

            ANAKIN
Because you're jealous!  You can
sense my powers growing stronger
than yours -- maybe even stronger
than theirs.

                                                    37.

            OBI-WAN
As your mentor and your friend, I
urge you not to pursue this.  It is
dangerous.

            ANAKIN
To you, maybe.  Are you afraid that
the student will eclipse the "master"?

His hand is on his lightsaber.  For a tense moment they stare at
each other, then they turn toward the doorway.  NANA DORDE, a
ten-year old female Twi'lek Padawan watches them, her large eyes
full of trepidation.  Obi-Wan forces himself to relax.

            OBI-WAN
We will speak of this later.  There
will come a time when you must
choose between your duty and your
feelings.

Anakin stalks away.  Obi-Wan looks after him, disturbed.


EXT. EXECUTIVE QUARTERS BUILDING - NIGHT

The lights of the enormous city spread out seemingly to infinity
around it.


INT. CHANCELLOR'S OFFICES - NIGHT

Anakin stares out of the balcony window at the myriad lights of
the city.  Palpatine watches from his desk, the shadows making
him appear hooded.

            PALPATINE
Being a Jedi is a difficult
undertaking.

            ANAKIN
You can't imagine.

This brings a slight smile to Palpatine's lips.

            ANAKIN
They act like I've never done
anything useful . . .

            PALPATINE
Perhaps it is the Jedi who are no
longer useful.

Anakin looks back at him, surprised.

                                                    38.

            PALPATINE
Oh, once, it is true, they were a
great force for peace and order.
But now . . . they have always had
difficulty with change.

            ANAKIN
They act like I can't be trusted.
Just because I have these feelings --

            PALPATINE
I understand completely, my boy.
For all of their powers, it would
seem there are some things the Jedi
simply don't understand.

Anakin smiles gratefully.  Palpatine gets up, and goes to
Anakin's side.  He looks thoughtful.

            PALPATINE
And perhaps they fear you.

            ANAKIN
Fear me?  Why?

            PALPATINE
Because they foresee you outgrowing
them, becoming more powerful than
any . . . or perhaps all of them.

Anakin considers the possibility as Palpatine watches.

            PALPATINE
As to your marriage, I can see no
valid reason why you should not be
allowed to share your happiness --
your love for each other.

            ANAKIN
As long as I'm a Jedi, it's forbidden.

            PALPATINE
Yes, as long as you're a Jedi . . .

Anakin looks into Palpatine's sympathetic eyes.  On the distant
horizon, lightning flickers.


INT. PADME AND ANAKIN'S APARTMENT - NIGHT

Anakin and Padmé eat in silence.  She glances at him, he
continues to stare at his plate.  Finally:

                                                    39.

            ANAKIN
I've been thrown out of the Jedi.

Padmé reacts, shocked, puts her hand over his.  Their eyes meet.

            PADMé
I'm . . . Anakin -- what --

            ANAKIN
Don't look so upset, it's not the
end of the universe.

            PADMé
How can you say that?  As long as
I've known you, all you've ever
wanted was to be a Jedi.

He shrugs, evasive, pulls his hand away, continues eating.
Padmé watches, sensing that there's more.

            ANAKIN
I've been thinking about leaving
anyway.  I wouldn't be the first,
you know.

            PADMé
What will you do now?

            ANAKIN
Supreme Chancellor Palpatine has
already offered me an important
mission.  He says it's vital to the
future of the Republic.

She looks down, troubled.  Anakin becomes annoyed.

            ANAKIN
What?  Do you think I won't be able
to handle it?  You have no faith in
me either?!

            PADMé
No, of course not, but --

He sullenly returns to his food.  She starts to reach over and
touch him, but withdraws her hand.


EXT. JEDI TEMPLE - TRAINING VERANDA - NIGHT

Obi-Wan and Mace Windu walk through darkened area.  A few Jedi
train padawans in lightsaber technicques and other martial moves.

                                                    40.

            MACE WINDU
It's a bad time for him to be
alone, Obi-Wan.  Now, more than
ever, he needs guidance.

            OBI-WAN
I know, I know, but I truly think
I'm the last person he wants to see
right now.

            MACE WINDU
You've always been closer than
master and padawan.

            OBI-WAN
We were.  I should consult with
Yoda.  He did try to warn me
Anakin's becoming a Jedi could be
dangerous.

Mace Windu puts a hand on Obi-Wan's shoulder.

            MACE WINDU
We all sensed the anger, the
darkness in him when Qui-Gon
brought him before us.

            OBI-WAN
But I'm the one who made Master
Yoda agree to accept him as my
padawan.

            MACE WINDU
Do you really believe anyone can
make Yoda do anything he doesn't
want to?  No, Obi-Wan, these events
were fated to transpire, despite
anything we did . . . or didn't do.

Obi-Wan looks at him, wanting to believe that.


EXT. CORUSCANT - OLD TOWN - NIGHT

This sector is deserted, burned-out, dark, and gritty, its
structures huge and weather-beaten.


INT. WAREHOUSE - NIGHT

Anakin stands in semi-darkness, eyes shut.  His lightsaber is in
his hand, unlit.  His breathing is quick, tense.

                                                    41.

Something moves in the shadows.  He raises his weapon slightly,
but doesn't ignite it.  Around him in the darkness, vague forms
move.  He forces himself to remain still.

A half-dozen BATTLE DROIDS dart out of the darkness, weapons
raised.  In one smooth move, Anakin ignites his weapon and flips
up -- landing behind the nearest droids, he slashes through them
with savage ease.  The droids only get off a few shots before he
decimates them.

He stands a moment, breathing hard.  His head snaps up.  Twenty
BATTLE DROIDS, including three DROIDEKAS, emerge.

In a dark corner of the gothic structure, Palpatine watches, a
satisfied smile on his face.

The droids charge, weapons blazing.  Anakin's lightsaber whips
around with impossible speed.  Droid parts and deflected laser
bolts fly everywhere.


A droideka wings him with a laser bolt.  Anakin becomes enraged.
He leaps into a double flip, and savagely slices the droideka
into scrap metal, using deflected laser bolts and his weapon.

His face, as he fights, shows that he's enjoying the destruction
immensely.  Ten battle droids surround him and move in.
Anakin's hand whips up -- heavy machines are ripped free from
their rusted moorings --

-- and SMASH six battle droids between them.  The others fire at
Anakin.  He flips up into the darkness, and hangs from a metal
catwalk.

He closes his eyes, concentrating, sweat beading on his forehead.
A powerful wind springs up -- the hapless droids are hurled into
the walls.  One droideka anchors itself to the concrete floor
and rides out the mini-storm.

Anakin leaps at the last droideka, deflecting its rapid-fire
laser bolts.  He lands in a crouch, and thrusts out a hand --
searing bolts of dark lightning engulf the droideka.  With a
mechanical SCREAM -- it's circuits fry and fuse.

Breathing heavily, Anakin rises, his eyes blazing.  Palpatine
emerges from the shadows, applauding.  He puts a hand on
Anakin's shoulder, beaming.  Anakin smiles, suffused with pride.


INT. JEDI TEMPLE - YODA'S CHAMBERS - NIGHT

Yoda cries out in pain.  Concerned, Obi-Wan hurries in.

                                                    42.

            OBI-WAN
Master Yoda -- what is it?  What's
wrong?

He kneels beside the diminutive Jedi.  Yoda looks up, trembling,
attempts to gather his strength.

            YODA
A . . . great disturbance do I feel
in the Force . . . danger . . .
enormous peril do I sense . . .

            QUI-GON (OS)
Anakin is being seduced by the dark
side.

They turn to see QUI-GON JINN's spirit standing before them,
surrounded by a glowing halo.  Yoda shakes his head, his worst
fears confirmed.

            YODA
Your prediction . . . fallen short
it has, Qui-Gon.

Qui-Gon settles before them with a weary sigh.

            QUI-GON
Not necessarily.  Anakin's children
will carry almost as many
midichlorians as he does.  Perhaps
that is what I sensed, and --

            OBI-WAN
Convenient.  And if that doesn't work?

            QUI-GON
Still no faith, Obi-Wan?  Skywalker
is our one hope.  I hold to that.

            YODA
Mmm, though a deadly Sith would he
be.  Powerful enough, perhaps, to
destroy us.

Obi-Wan and Qui-Gon look at each other, uneasy.

            QUI-GON
There is one person who still might
be able to reach him.

                                                    43.

EXT. CORUSCANT - SENATE BUILDING - DAWN

Padmé steps out of a transport looking as if she hasn't slept.
Human and alien delegates come and go, chatting.  She's startled
when Obi-Wan steps in front of her, quickly transitions to anger.

            PADMé
You promised you wouldn't let the
council punish Anakin.  You lied to
me.

            OBI-WAN
I'm afraid it's not that simple.

Disgusted, she walks off.  Obi-Wan catches her arm.  She spins,
glares at him.

            OBI-WAN
I know you're angry, and I don't
blame you.  All I ask is that you
hear me out.

            PADMé
Why should I?

            OBI-WAN
Because Anakin may be in great
danger, and I want to help him.

She searches his face, sees he's speaking the truth.  She nods
reluctantly.


EXT. SENATE PLAZA - GARDEN - DAY

Padmé and Obi-Wan sit under a beautiful sorapus tree, shaded by
its exotic blossoms.

            PADMé
No, he only said that Palpatine had
a special assignment for him,
something very important.

She shakes her head.

            PADMé
I . . . don't know if I entirely
trust Palpatine any more, especially
after his last speech.

            OBI-WAN
I heard, although perhaps we
shouldn't jump to conclusions.

                                                    44.

            PADMé
I thought Jedi always went with
their instincts.

            OBI-WAN
It's a tricky line to walk,
especially in times like these.

            PADMé
You fear for the Republic also,
don't you?

            OBI-WAN
I fear there are dark times ahead,
yes.  You realize that you will
also become a target, if the Sith
discover that you carry his child.

            PADMé
Anakin wouldn't let them harm us.
He wouldn't.

Obi-Wan doesn't respond.  Exotic birds soar past them through
the trees.


EXT. MILITARY STAGING AREA - BALCONY - DAY

Palpatine and Anakin look down from a reviewing stand on
thousands of Troopers arranged in platoons in the square below.
Immense air tanks, AT-ATs also line the field.

            ANAKIN
It's impressive, Chancellor, though
it seems a bit extreme for a few
recalcitrant systems.

            PALPATINE
Don't be fooled, Anakin, they are
stronger, and far more numerous
than one might think.  It will take
a strong hand to save the Republic .
. . and carry it forward into a
glorious new age.

Anakin nods slowly, looks out over the Troopers.

            PALPATINE
I foresee that you will rise
quickly in power and position.  I
always knew you were destined for
greatness.

Anakin glances toward the city.  Palpatine notes his distraction.

                                                    45.

            PALPATINE
What is it, my boy?

            ANAKIN
Padmé.  I just . . .

            PALPATINE
Of course you do, and quite rightly.
Go to her, Anakin.  All this will
wait.

Anakin smiles gratefully.  As he leaves, Palpatine begins to
chuckle.


EXT. CORUSCANT - APARTMENT BUILDING - DAY

Outside the complex where Padmé and Anakin live.

            ANAKIN (OS)
You don't understand!  This is a
chance -- a real chance --


INT. PADME AND ANAKIN'S APARTMENT - DAY

            ANAKIN
-- to finally do something
important!  To realize my destiny!

She regards him as he paces, agitated.

            PADMé
What about the Jedi?

He turns away in disgust.  His shadow on the wall has begun to
resemble Vader's infamous silhouette.

            PADMé
Are you just going to throw
everything they've given you away?
Everything you've --

            ANAKIN
What did they give me?!  I had
these abilities before I went to
them, that's why they were
interested in me in the first --

            PADMé
But would you have been able to
develop them on your own?  Would
you?  Honestly?

                                                    46.

            ANAKIN
I know you can't see it now, but
what I'm doing is for the best.  My
path doesn't lie with them.  The
Jedi are . . . they've lost their
power.

Padmé grabs his arm, pulls him around.

            PADMé
You don't believe that!  That
sounds like Palpatine --

ANAKIN                           PADMé
Supreme Chan --                  Can't you see what he's doing?
                         What he's becoming?

            ANAKIN
He's making the best decisions for
all of us --

            PADMé
By overburdening us with new laws?
Arresting thousands of people and
accusing them of sedit --

ANAKIN                           PADMé
He knows what he's --            How do you know that?!  How
                         do you know . . . ?

Anakin hesitates, momentarily unsure.  She slips up against him,
trembling, he puts his arms around her.

            PADMé
Oh, Anakin . . . Anakin . . .
please don't do this.  It isn't
right, I have a bad feeling about
this.

            ANAKIN
I thought you'd understand.  You
saw what the unchecked power of the
Federation did on your world.


            PADMé
What about the atrocities committed
by clone troops occupying the
separatist systems?

            ANAKIN
. . . There's no proof of that.
Don't let other people's lies --

                                                    47.

            PADMé
Why did you lie to me about being
expelled from the Jedi?

Anakin looks away, growing angry and frustrated.

            ANAKIN
I'm right, you'll see.  When we've
put down the last of the rebel
systems --

            PADMé
Then who will you go after?  Oh,
Anakin, can't you see -- this isn't
the answer.  Come with me.  Talk to
Obi-Wan.  Please.

He considers it, shakes his head slowly.  Padmé pulls free of
his arms, moves away.

            ANAKIN
Padmé --

            PADMé
You're going to have to decide
what's more important.  Let me know
when you have.

She goes into the bedroom.  He starts after her, stops when the
door slides shut.  Angry, he sweeps an arm -- a large statue
flies across the room and crashes against the wall, startling
him.  He slumps down on the sofa, torn with indecision.


EXT. SPACE - ALDERAAN

A jedi starfighter undocks from its hyperspace ring and flies
toward the planet.


EXT. ALDERAAN - SENATE BUILDING - DAY

A magnificent, sprawling eco-edifice designed to blend
harmoniously with its surroundings.  Graceful statues adorn the
terraced walks, fountains sparkle in the sunlight.

A Jedi starship lands on the courtyard landing pad.  The ramp
lowers, and Mace Windu emerges.  Bail Organa greets him warmly,
they walk toward the building.

            BAIL ORGANA
It's good to see you again, Master
Windu.

                                                    48.

            MACE WINDU
We're anxious to see how the
reconstruction's proceeding.  Any
problems?

            BAIL ORGANA
On the contrary, as Viceroy and
First Chairman of the new Council,
I've outlawed all weapons on Alderaan.

Mace Windu seems unsure if this is a good idea.

            BAIL ORGANA
The Clone Wars made me realize that
there's no such thing as a
defensive weapon.  I know that's
not your way . . .

            MACE WINDU
On the contrary, I sincerely hope
the other systems adopt your attitude.

            BAIL ORGANA
Extremely doubtful.  Anti-Jedi
sentiment is growing steadily.
Many delegates are convinced the
clones are a better solution for
maintaining order.

            MACE WINDU
In time, hopefully they'll see the
light.

            BAIL ORGANA
I wish I shared your optimism.  By
the way, I've received a
communication from Rune Haako.  He
wants to talk with the Jedi.

            MACE WINDU
Now why would he want to do that?

            BAIL ORGANA
Palpatine's had him imprisoned.  He
says he has important information
which he's willing to exchange for
safe passage to Alderaan, and
diplomatic immunity.

            MACE WINDU
Interesting.  Do you believe him?

                                                    49.

            BAIL ORGANA
Neimoidians are greedy and cruel,
but they always know where their
best interests lie.  It might be
worth checking into.

            MACE WINDU
It may, indeed.

They pass ceremonial guards at attention and enter the building.


INT. PADME AND ANAKIN'S APARTMENT - DAY

Obi-Wan looks up as Padmé enters, sits beside him wearily.

            OBI-WAN
I take it you've had no luck.

            PADMé
He's so angry, so defensive.  He's
closing himself off, I can feel it.
And I don't know how to help him.

            OBI-WAN
The Jedi have agreed to re-instate
him.

            PADMé
That's wonderful news!  But I don't
know if it's enough.

            OBI-WAN
You are both in grave danger here.

            PADMé
If you're asking me to leave him --

            OBI-WAN
Only until we can persuade him to
come back.

She looks away, shaking her head.  Obi-Wan gently takes her
hand, she looks at him, surprised.

            OBI-WAN
I wouldn't ask if it wasn't vitally
important.  I don't think Anakin
will try to harm you, but there are
others . . .

            PADMé
Can you help him?  Can you, Obi-Wan?

                                                    50.

            OBI-WAN
I won't rest until we've reclaimed
him.  I understand Ambassador Binks
is returning to Naboo to attend a
ceremony in his honor.

She reacts, surprised, then eyes him suspiciously.

            OBI-WAN
Promise me you'll go with him.

He smiles at her skeptical look.

            OBI-WAN
No Jedi mind tricks.  They only
work on the weak-minded, anyway.

            PADMé
I'll go if you promise to keep me
informed.

            OBI-WAN
There's that renowned stubborness
again.  All right, I promise.

She smiles, relieved.  Threepio skitters in, all a-twitter.

            THREEPIO
Oh!  Pardon me, mistress -- master
Obi-Wan, I believe that Mace Windu
has an important message for you, sir.

Obi-Wan rises, tense.

            OBI-WAN
Where is he?

            THREEPIO
He wants you to meet him at the
main correctional facility in the
Bogani Sector.  It's a horrible --

            PADMé
What's he doing there?

            THREEPIO
I'm certain I have no idea,
mistress.  It's all quite mysterious.
Why he didn't simply communicate by
holo --

                                                    51.

            OBI-WAN
Because holograms can be
intercepted, my excitable friend.
Padmé --

            PADMé
I'll be waiting to hear from you.
Good luck.

            THREEPIO
Eh?  I beg pardon, but is there
anything that I --

Obi-Wan hurries out.  Threepio looks after him, then turns to
Padmé, but she's already gone.

            THREEPIO
Whatever in the -- oh!  Goodness!
Everything's happening just a bit
too quickly for me, and I just know
that it's all Artoo Detoo's fault,
somehow.

He trundles after her.


EXT. MONTROSS MAXIMUM SECURITY FACILITY - DAY

An imposing penitentiary surrounded by high-tech towers,
patrolled by armed Troopers.  Skimmers and one-man speeders zip
past constantly, their WHINE filling the air.  Mace Windu and
Obi-Wan approach the main gate.

            OBI-WAN
What makes you think we can trust a
cowardly ex-Trade Federation lackey?
He may be attempting to save his
own worthless hide.

            MACE WINDU
Agreed, but he's the only surviving
official from the Naboo incident.

            OBI-WAN
Do you think he may know who and
where Sifo-Dyas is?

            MACE WINDU
I think we can't afford not to find
out.

A brusque CLONE TROOPER steps into their path, his blaster rifle
ready.

                                                    52.

            CLONE TROOPER
Halt.  What is your business here?

            MACE WINDU
We've come to interview one of the
prisoners.

            CLONE TROOPER
I wasn't informed, I'll have to
clear it.  Let me see some
identification.

With a mischievous smile, Obi-Wan waves one hand slightly.

            OBI-WAN
You don't need to see our
identification.

Mace Windu cocks an eyebrow.  The Trooper reacts, confused.

            CLONE TROOPER
I -- don't need to see your
identification . . .

            OBI-WAN
As a matter of fact, you've been
expecting us.

            CLONE TROOPER
I've -- been expecting you.

            OBI-WAN
You were about to take us to see
Rune Haako.

            CLONE TROOPER
I -- will take you to see Rune
Haako.  Come with me.

He marches toward the prison, activating the gate.  As the Jedi
follow:

            MACE WINDU
That isn't quite fair, you know,
taking advantage of the weak-minded.

            OBI-WAN
Sorry, it's becoming a bad habit.

Mace Windu smiles as they enter the fortress.

                                                    53.

INT. MONTROSS MAXIMUM SECURITY FACILITY - CELL BLOCK - DAY

The Trooper leads them past numerous cells containing hardened
criminals:  Aqualish, Rodians, and Weequays.  The surly
miscreants snarl and JEER at them.

            RODIAN
(in his language) Hey, Jedi -- you
come to spring me loose?

Several of them laugh nastily, rattle their cell doors
threateningly.

            AQUALISH
Yeh, me too, ######!  Lemme out, I
show you how grateful I be!  Rarrrrgh!

He swipes an arm at them.  Mace Windu and Obi-Wan exchange a
look as they walk the gauntlet of JEERS and SNARLS.


INT. MONTROSS MAXIMUM SECURITY FACILITY - RUNE HAAKO'S CELL

The Jedi are let in, Obi-Wan nods to the Trooper.  He exits,
still confused.  Rune stumbles to his feet, clutching tremulously
at the Jedi.

            RUNE
Y-you have come to save me?  You
will take me out of here?

            MACE WINDU
Perhaps.

            RUNE
You must!  My life -- it is not
worth Bantha poodu!

            OBI-WAN
Calm down, will you?  It depends on
what you have to tell us.

Rune looks at them craftily.

            RUNE
Eh, what promises do I have?  This
information, it is very, very
essential.

            MACE WINDU
If so, we will provide safe passage
off Coruscant.

                                                    54.

            RUNE
That's all?!  Passage to where?!
I'm a marked man, I need more than
that!

They shrug, turn toward the door.

            RUNE
Wait!  All right, all right . . .

They move closer, Rune shudders.

            RUNE
A Sith Lord who called himself
Darth Sidious orchestrated the
entire operation from start to
finish.  Everything.

            OBI-WAN
Who is he?

            RUNE
I don't know . . . I don't, I tell
you!  We just followed his orders.
But he either has spies, or is a
member of the Senate himself.

            MACE WINDU
Why do you say that?

            RUNE
Because he knew -- beforehand --
every move they made.  Even told us
two Jedi were being sent to
"negotiate".

            OBI-WAN
Qui-Gon Jinn died there because of
your machinations.

            RUNE
It wasn't me!  I swear -- it wasn't
me!  I just followed orders!  Look,
I told Gunray we were making a big
mistake, but would he listen?
Noooooo!  Now --

            MACE WINDU
You have no idea who this Sith
might be?

They look at him closely.  Rune glances nervously from one to
the other.

                                                    55.

            RUNE
I . . . listen, this may sound
crazy, but . . .

            OBI-WAN
Let's hear it anyway.

Rune shudders, looks around, frightened.

            RUNE
Well, I was in Palpatine's office
earlier, with Lott Dod?  We had an
argument, and . . .

            OBI-WAN
And what?

            RUNE
He -- Lott Dod -- he just -- I
don't know . . . he started
choking, gasping for breath.  Then
he just -- fell over, dead, but
nothing touched him.

The Jedi react, startled.  Obi-Wan grabs Rune Haako's arm
roughly, making him wince.

            OBI-WAN
You're certain of that?!

            RUNE
Y-yes -- yes!  I swear it!  I was
frightened -- I couldn't see what
killed him!  I thought I would be
next!

He shivers as the Jedi exchange tense looks.


INT. MONTROSS MAXIMUM SECURITY FACILITY - CORRIDOR

An armored FIGURE eases into position around the corner, just
out of sight of Rune's cell.


INT. MONTROSS MAXIMUM SECURITY FACILITY - RUNE HAAKO'S CELL

Rune watches the Jedi apprehensively.  They're taking too much
time to make up their minds to suit him.

            OBI-WAN
Could it be?

                                                    56.

            MACE WINDU
We were warned that the Sith had
taken control of the Senate.

            OBI-WAN
And they've been able to keep us
from suspecting.  Perhaps --

            RUNE
Yes, yes, but when are we getting
out of here!?

            OBI-WAN
He's right.

            MACE WINDU
Come on.  And stay close to us.


INT. MONTROSS MAXIMUM SECURITY FACILITY - CORRIDOR

They emerge warily.  Around the corner, the armored figure
raises his blaster.  They hurry down the hall away from him.  He
steps into view -- it's BOBA FETT in his father's Mandalorian
armor.  He blasts Rune Haako.

            RUNE
Aaaaaaaghghghgh --

He falls in a smoking heap.  The Jedi spin around, igniting
their lightsabers.  Mace Windu reacts, startled, when he sees
the armor.

            BOBA FETT
You!!!

He aims his blaster -- ALARMS go off everywhere.  Prisoners HOWL
and SHRIEK wildly, BANGING on their cell doors.  Boba Fett darts
off down the hall.  Obi-Wan starts to follow him, Mace Windu
pulls him back.

            MACE WINDU
We have to get out of here.

They run down the corridor.  Lights strobe, they HEAR the SOUND
of ARMOR up ahead.  A squad of Troopers runs past, weapons ready.
When they're gone, the Jedi emerge from behind a large column,
move off in the opposite direction.


INT. SENATE CHAMBER - DAY

It's packed, restless as Palpatine assumes his position atop the
central pinnacle attended by IV GIZEN and four personal Guards.

                                                    57.

He looks out over the gathering.

            PALPATINE
I am afraid that I bring ill news,
my friends.  It has come to my
attention that the Jedi have allied
themselves with the seditionists
against the Republic.

The chamber erupts in bedlam.  Most SHOUT angrily against the
Jedi, but a handful, including Bail Organa, SHOUT rebuttals.
Palpatine raises a hand for silence.

            BAIL ORGANA
I don't believe it!  What proof is
there!

            PALPATINE
Altogether too much.  They and the
Neimoidians were attempting to re-
establish control of the Federation.

The delegates SHOUT angrily.  Mas Amedda BANGS his gavel.

            MAS AMEDDA
Order!  ORDER!!!

Bail Organa's platform rises to a position before the pinnacle.

            BAIL ORGANA
The Jedi must be allowed to speak
before the Senate to address these
allegations!

VOICES of support and descent echo throughout the chamber.
Palpatine stares coldly at Organa.  He returns the look calmly.


INT. MONTROSS MAXIMUM SECURITY FACILITY - CORRIDOR - DAY

Troopers are everywhere.  Obi-Wan peeks out from a cell, ducks
back in.


INT. MONTROSS MAXIMUM SECURITY FACILITY - CELL

            OBI-WAN
This isn't going to be easy.

            MACE WINDU
It never is.  I think our best
chance is the roof.

                                                    58.

            OBI-WAN
The -- what exactly are we planning
to do?

Mace Windu smiles, eases out of the cell.  Obi-Wan follows with
trepidation.


INT. MONTROSS MAXIMUM SECURITY FACILITY - CORRIDOR - DAY

They run down the hall, ALARMS ringing.  Suddenly, a dozen
Troopers appear, barring their way.

            OBI-WAN
This is beginning to feel
distressingly familiar.

            CLONE TROOPER
You will lay down your weapons and
surrender immediately!

The Jedi ignite their lightsabers.  The Troopers fire, the Jedi
parry and deflect their laser blasts, and cut them down.  Obi-
Wan pauses, a look of regret on his face.

            MACE WINDU
It was necessary.  Unless you plan
to stay here.

Obi-Wan follows him down the hall.


EXT. CORUSCANT - OLD TOWN - DAY

High above the dirty streets, Palpatine walks toward Anakin who
sits atop a large, pitted gargoyle statue, brooding.  He looks
up, a strong wind whips at their cloaks, THUNDER rumbles in the
distance.

            ANAKIN
A storm is coming.

            PALPATINE
What troubles you, my friend?
Come, you may feel free to confide
in me, I hope.

            ANAKIN
Padmé . . . she said some disturbing
things . . .

                                                    59.

            PALPATINE
Eh?  What sort of -- ah, I see.
She has begun to distrust Our
motives, has she?

            ANAKIN
We've always been able to understand
each other.  Her resistance . . .

He looks at Palpatine, needing reassurance.  Palpatine ponders a
moment, then sighs.

            PALPATINE
No doubt she is troubled by some of
the means we have had to employ, as
am I, I assure you.  Sometimes we
must do things . . .

He puts a hand on Anakin's shoulder.

            ANAKIN
Why can't she see that what we're
doing is for the common good?

            PALPATINE
Perhaps she has spent too much time
with the Jedi.  They can be quite
persuasive, as you well know,
especially Master Yoda.

Anakin's eyes blaze.

            ANAKIN
If they've been influencing her
mind, they'll answer to me for it!

            PALPATINE
If you like, I can have someone
keep an eye on her.

Anakin nods gratefully.

            PALPATINE
You have been training very hard.
Why don't you try and get some rest?

            ANAKIN
All right.

He jumps down, and after a final look at Palpatine, he heads out.
Palpatine's smile immediately vanishes.

                                                    60.

INT. MEDITATION CHAMBER - DAY

Dooku sits in meditation on a raised platform.  A hologram of
Darth Sidious appears.  Dooku nods reverently.

            DARTH SIDIOUS
The Jedi would utilize Lady Amidala
to soften Skywalker's resolve.

            DOOKU
Surely she cannot.  Not now.

            DARTH SIDIOUS
I do not intend to leave that to
chance.  Take her into custody
immediately.

            DOOKU
And Skywalker?

            DARTH SIDIOUS
Leave him to me!

Dooku bows as Darth Sidious cackles with glee.


EXT. MONTROSS MAXIMUM SECURITY FACILITY - ROOF - DAY

Troopers patrol the perimeter, two-man speeders and speeder
bikes zip past overhead.  Obi-Wan and Mace Windu peer out from
behind an environmental control unit.

            OBI-WAN
I'm almost afraid to ask this . . .

            MACE WINDU
We'll never get away on foot.

            OBI-WAN
That much is obvious.

            MACE WINDU
So our alternative is . . .

Obi-Wan thinks a moment, then glances up, shakes his head.

            OBI-WAN
I haven't learned how to fly yet.

            MACE WINDU
You may surprise yourself.  Come on.

They dash toward some speeder bikes guarded by a dozen Troopers.

                                                    61.

            CLONE TROOPER
There they are!  Blast 'em!

Deadly laser bolts zip at the Jedi.  They deflect them, cutting
down the Troopers.  Obi-Wan battles several Troopers, Mace Windu
leaps onto a bike, fires it up.

            MACE WINDU
Obi-Wan, let's not overdo it!

Obi-Wan dashes to a bike as Mace Windu rockets off.  Obi-Wan's
bike won't start.

            OBI-WAN
Blast!

He desperately works the mechanism.  Searing laser bolts blast
the bike, knocking it over.  He springs up and runs for the roof
edge, deflecting laser bolts, chased by twenty Troopers.

He cuts down several Troopers, fights his way to the edge.  He
looks down.  Three speeder-bike mounted Troopers ROAR toward the
roof.  Obi-Wan takes a deep breath --

-- and leaps onto one as they pass.  They struggle briefly, he
bashes the Trooper in the head, and flips him off the bike.  He
looks up -- he's speeding toward the facility wall.

Just before impact he swerves up and away, followed by a hail of
laserfire.


EXT. CORUSCANT - DAY

Obi-Wan maneuvers into the rush of traffic.  A moment later,
laser bolts sizzle past, some EXPLODING against other vehicles,
causing them to swerve.  General panic breaks out.

Obi-Wan looks back.  Six speeder bikes bear down on him, firing
their lasers.  He swerves and weaves in and out of traffic,
attempting to lose them.  The Troopers blast several transports
out of their way.

They tear into towering holographic billboards.  For a mad
moment they fly through a dizzying rush of commercials, so its
difficult to tell who's shooting at who.  Obi-Wan shoots out of
the mouth of a beautiful alien model into a hail of laserfire.

            OBI-WAN
Damn!

He zips up and over in a hair-raising loop, lets go, and ignites
his lightsaber.  He lands on the bike of one of his pursuers,
and dispatches him.

                                                    62.

The bike careens wildly, then zips in and out of a narrow
openings between towering buildings.


EXT. CORUSCANT - DOWNTOWN - DAY

Obi-Wan and his pursuers streak through the main business
district.  It's rush hour, and the skies are jammed with
speeders, air taxis, transports and sky bikes ridden by punked-
out youths.

Several of the bikers join the chase, adding to the confusion
until they're run off by the Troopers.  Several transports and
taxis are forced out of the way, and collide.

Obi-Wan desperately tries to lose his pursuers.  Two pull up on
either side of him, another drops down in front.  They attempt
to force him down.

One aims his blaster rifle.  Obi-Wan stalls his bike out and
plummets.  The Clone blasts his buddy off his bike.

Obi-Wan hurtles toward the street hundreds of stories below,
twisting wildly to avoid collisions as he fights to restart the
bike.  It catches just before he hits a large air-bus, and he
zooms away, leaving the commuters gaping.


EXT. CORUSCANT - INDUSTRIAL DISTRICT - DAY

Obi-Wan tears through the district at frightening speed, pursued
by two Troopers.  Laser bolts fly past the Jedi dangerously
close as he swerves toward a factory.


INT. FACTORY - MAIN FLOOR - DAY

Recommisioned Battle Droids assemble heavy war machinery.  Obi-
Wan and his pursuers blast through, narrowly avoiding being
smashed to bits on crane arms and claw lifters.  Obi-Wan glances
back at a group of droids.

            OBI-WAN
I thought they'd been dismantled --

A Trooper drops down a level and pulls ahead.

Obi-Wan sees a metal walkway loom before him.  Timing it, he
leaps and grabs onto it, hanging.  The Trooper zooms up in front
of him, and is smashed by the riderless bike.

Obi-Wan dangles hundreds of feet above the floor, surrounded by
sparking, sizzling, smoking machinery.  He looks up --

                                                    63.

The last Trooper speeds toward him, lasers blasting.  At the
last minute -- another bike zooms up -- and Mace Windu slices
the Trooper's bike's steering vane in half.

The bike crashes into a molten ingot cauldron, melting the bike
and its rider.  Mace Windu hovers beside the breathless Obi-Wan.

            OBI-WAN
Great plan.  I think next time I'll
take the dangerous option.

He leaps onto the back of the bike, they ROAR off.


EXT. JEDI TEMPLE - SUNSET

Bathed in the colorful rays of the setting sun, it seems to be
at the center of a gathering darkness.


INT. JEDI TEMPLE - COUNCIL CHAMBERS - SUNSET

Obi-Wan and Mace Windu face the Council.

            YODA
Battle droids, say you?  Most
interesting this is, Obi-Wan.  And
most dangerous.

            EETH KOTH
Indeed.  To accuse the Supreme
Chancellor of conspiring with the
Sith . . .

            PLO KOON
Still, something must be done.

            YODA
Agree, do I most heartily.  An
opportunity to speak before the
Senate have we been offered.

            OBI-WAN
To answer allegations of treason!
Madness!

            YODA
Guard well your feelings, Obi-Wan.
Something, I sense, is not right.
Far more than mere collusion do I
suspect.

He rises, and moves toward the door with Obi-Wan and Mace Windu.

                                                    64.

EXT. SPACE

A Naboo light cruiser speeds through the starry void, accompanied
by two N-1 starfighters.


INT. NABOO CRUISER - MAIN CABIN

Padmé and Jar Jar sit at the conference table with Dormé and
Captain Typho, Threepio bustles about in the background.

            PADMé
I still don't like the idea of
running away.

            TYPHO
You aren't running away, M'Lady,
you're being prudent.

She gives him a doubtful look.

            JAR JAR
Mesa agreein' wit' dat, Padmé.  You
haven to concern youself bout moren
one life now, eh?  Better you beein
someplace not so easy to find, heh?

            TYPHO
As long as the political climate --

The ship's shaken by an EXPLOSION!  ALARMS go off.

            THREEPIO
Oh!  Oh, my!  What's that?!  What's
happening?!

            PADMé
Quiet!

She watches tensely as Captain Typho goes to the intercom.

            TYPHO
Bridge!  What's going on?


INT. NABOO CRUISER - BRIDGE

The crew mans their stations, under attack.  The ship shakes
from several more hits.

            PILOT
We're under attack, sir!

INTERCUT with Padmé and the others.

                                                    65.

            TYPHO
Attack?!  Blast it, who --

            PADMé
We're on our way up!

They rush past the bewildered Threepio, who toddles after them.

            THREEPIO
Wait -- wait for me!


EXT. SPACE

Slave 1 fires rapid lasers at the cruiser.  EXPLOSIONS occur on
the larger ship, including one of the engines.


INT. SLAVE 1 - CABIN

Boba Fett smiles as he fires his laser cannons.  Through the
forward viewport, he sees the two N-1s moving toward him.


EXT. SPACE

Slave 1 blasts the two N-1s -- they EXPLODE!


INT. SLAVE 1 - CABIN

AURRA SING puts a restraining hand on Boba Fett's shoulder.

            AURRA SING
Time to enjoy ourselves later, pet.
Stay focused.

He grunts a reply, swings the ship around.


EXT. SPACE

Slave 1 zooms around and heads toward the Naboo ship, which has
sustained considerable damage.


INT. NABOO CRUISER - BRIDGE

Padmé races in, followed by Jar Jar and Captain Typho.

            PADMé
What is it?  What's going on?

                                                    66.

            PILOT
They're not answering our hails.

            TYPHO
Inform them we're a diplomatic ship
from Naboo carrying the Senate
delegation.

            PILOT
I'm trying to --

Threepio enters as a hologram of Aurra Sing shimmers before them.

            AURRA SING
Stand down.  Prepare to be boarded!

            THREEPIO
Good heavens!  Who is that?

            TYPHO
You have no right to --

            AURRA SING
NOW!  Or we will blast you to atoms.

            THREEPIO
Oh!  Oh, dear!  Captain, might I
suggest --

Padmé makes a slashing gesture, Threepio subsides.  The hologram
fades.

            PADMé
Can we outrun them?

            PILOT
Our main engine drive's been hit.

            THREEPIO
Pardon me, mistress, but if I might
make a suggestion, surrender is a
perfectly --

            TYPHO
Go for it!


EXT. SPACE

The Naboo ship turns and tries to outrun Slave 1, but she's
crippled and listing.  She fires shots that Slave 1 easily avoids.

                                                    67.

INT. SLAVE 1 - CABIN

            AURRA SING
Fools!  Explain it to them.

She puts a restraining hand on Boba Fett's arm.

            AURRA SING
Remember -- we're supposed to take
prisoners.

Boba Fett shakes her hand off.


EXT. SPACE

The cruiser's engines are disabled by several blasts.


INT. NABOO CRUISER - BRIDGE

Consoles and stations EXPLODE, killing some of the crew.

THREEPIO                         JAR JAR
Oh!  Oh, my!  Oh -- heavens!     Deysa gonna destroyen ussen!

Equipment EXPLODES, fires break out around the bridge.  Padmé's
eyes narrow as she watches Slave 1 close the distance, still
firing.

            PADMé
Signal our surrender!

TYPHO                            PADMé
Senator, we --                   NOW!

Captain Typho nods to the Pilot, who keys in the message.

            THREEPIO
Thank goodness!  At last, a
sensible --

            PADMé
Send a distress signal to Naboo.
Outward band coded, all frequencies.

The Pilot nods.


EXT. SPACE

Slave 1 moves toward the crippled cruiser.

                                                    68.

INT. NABOO CRUISER - BRIDGE

They wait tensely.  The main hatch EXPLODES, and Aurra Sing and
Boba Fett enter, Boba Fett covering them with his blaster.

            THREEPIO
Oh!  Don't shoot!  Don't shoot!

            CAPTAIN TYPHO
We're unarmed!

Padmé and Dormé glare defiantly at Aurra Sing as she steps
toward them.  Jar Jar tries to block her way.  She unsheathes
her claw-nails, and he backs away.

            AURRA SING
Which one of you is Amidala?

Silence.  She nods to Boba Fett who steps forward and raises his
blaster.  Padmé and Dormé tense.

JAR JAR                          BOBA FETT
Now, just a --                   Shut up, freak!

Boba Fett blasts Jar Jar!  Jar Jar drops to the deck, in pain.
He looks up at Padmé who looks on in horror.  Aurra Sing smiles.

            AURRA SING
That wasn't so hard, was it?  You
will come with me.

            PADMé
You can't just leave him like that!

            BOBA FETT
No problem.

He blasts Jar Jar.  With a shuddering SCREECH, he dies.  Padmé
glares hatefully at Aurra Sing.  Aurra Sing shoves her roughly.

Dormé jumps her, and Aurra Sing rams an elbow into her face,
knocking her back.  She spins around, igniting her lightsaber,
and cuts Dormé down.  Padmé turns on her angrily, but Aurra Sing
cooly faces her with the weapon.

            AURRA SING
Don't be stupid, Senator.  I get
paid whether you're breathing or not.

Padmé backs off, Aurra Sing motions with her weapon.  Padmé
glances back at the others, walks toward the airlock.

            BOBA FETT
What about them?

                                                    69.

            AURRA SING
Is there a bounty on any of them?

            BOBA FETT
Not a credit.

            AURRA SING
Then get rid of them.

Padmé rushes back toward them.

            PADMé
No!

Boba Fett shoots her with a stun gun.  Padmé's knocked against a
bulkhead, and falls to the deck, out cold.

            THREEPIO
Oh!  Oh, my!  Senator Amidala!
Senator Amidala!

Aurra Sing whips around to face him.  Threepio cringes.

            AURRA SING
You!  You're her protocol droid?

            THREEPIO
Er, y-yes, ma'am.  I am See-
Threepio, human cyborg relations
and --

            AURRA SING
Take this one along also.

            BOBA FETT
What for?

            AURRA SING
He may have information.

            THREEPIO
Information?  Oh, my, I don't --

She points her lightsaber between his eye sensors.

            AURRA SING
Shut up!

            THREEPIO
Shutting up, ma'am.

Threepio looks from one to the other, shivering.

                                                    70.

EXT. SPACE

Slave 1 moves away from the drifting cruiser.  It fires a salvo
into her engines, causing her to EXPLODE.  Slave 1 powers up,
and blasts into hyperspace.


EXT. CORUSCANT - JEDI TEMPLE - DAY

A large contingent of Troopers lumbers toward the Temple from
all sides, including AT-TE, AT-ST, and SPHA-T (Self Propelled
Heavy Artillery-Turbolaser) walkers.


INT. JEDI TEMPLE - MEDITATION ROOM - DAY

Plo Koon meditates.  Nana Dorde rushes in, breathless and
frightened.

            NANA
Master -- Master!  We are under
attack!

Plo Koon moves to a window and looks out.

Vast columns of Troopers and lumbering war machines surround the
Temple.  Plo Koon turns calmly to the frightened Padawan, puts a
hand on her shoulder.  She becomes calmer.

            PLO KOON
Summon the Council.  And see to the
young ones.

She nods, and hurries out.  Plo Koon returns his gaze to the
window.


EXT. JEDI TEMPLE - DAY

It's completely surrounded.  Troopers snap to attention, all
eyes and weapons on the main entrance.  Plo Koon, Adi Gallia,
Eeth Koth, and fifty Jedi of various species walk calmly out and
face the invasion force.  The COMMANDER steps forward.

            CLONE COMMANDER
You are ordered to surrender
immediately.

The Jedi exchange knowing glances.  They aren't afraid, or
concerned.

            CLONE COMMANDER
I warn you, we are authorized to
utilize deadly force.

                                                    71.

            PLO KOON
What are the charges against us?

            CLONE COMMANDER
You will be advised of them in due
process.  Lay down your weapons,
and come with us.

The Jedi scan the thousands of Troopers.

            PLO KOON
We cannot possibly win.  Not
against this many.

            ADI GALLIA
And further conflict will only
cause more political damage.

            EETH KOTH
It would seem our only recourse is
to --

Suddenly, Anakin's starfighter streaks past and fires -- killing
several Troopers.

            CLONE COMMANDER
Open fire!

The nearest Troopers fire and the Jedi ignite their lightsabers.
They deflect the incoming bolts into the Troopers, felling
several as they begin to back toward the Temple.


INT. ANAKIN'S STARFIGHTER - COCKPIT - DAY - MOVING

A Clone Trooper is at the controls.  He banks the ship up and away.


EXT. JEDI TEMPLE - DAY

Troopers charge, weapons blazing.  Jedi use their lightsabers to
deflect the laser bolts.  A hundred Padawans stream out of the
Temple, lightsabers ignited, and join the hopeless battle.
EXPLOSIONS detonate all around them.  Troopers fall, but so do
Padawans and apprentices.


INT. SENATE CHAMBER - DAY

On a floating platform, illuminated by a powerful light, Yoda
faces Palpatine and the Senate.  Several delegates SHOUT
angrily, waving their fists.  Yoda is calm, his VOICE carries
clearly through the tumult.

                                                    72.

            YODA
Not your enemy are the Jedi!
Clouded the affairs of the Republic
have the Sith.  From them came the
Federation invasion of Naboo.

            ASK AAK
The Sith!  Bah!  Always you bring
up this tired myth to justify your
actions!  Show us some proof!

Most of the Senators SHOUT their support.  Obi-Wan and Mace
Windu, sharing Yoda's platform, look around uneasily.

            YODA
Produce them, I cannot.  But --

            DARSANA
Then why should we accept that they
exist?!

            YODA
Responsible for the Clone Wars were
they, hoping to destroy the Jedi,
and thus, the Republic.

Palpatine watches from his pinnacle, concentrating on the
delegates.  They grow more inflamed, less inclined to listen to
reason.  SHOUTS and CURSES echo around the vast chamber.

Yoda waits calmly as the uproar continues.  Many delegates SHOUT
and gesture angrily at the Jedi.

            YODA
Information were we given, that the
Sith have infiltrated the Senate.

Palpatine smiles tolerantly down at Yoda.

            PALPATINE
Do you accuse Us of conspiracy,
Master Yoda?

            YODA
Why did not -- aagh!

Yoda sways unsteadily, clutching at his chest.  Mace Windu and
Obi-Wan rush to his side.

            MACE WINDU
What is it?

            OBI-WAN
Master Yoda!  What's wrong?

                                                    73.

Yoda opens his eyes, and there's fear in them.  He shoots a look
up at Palpatine, who smiles back.

            YODA
-- Temple --

Mace Windu and Obi-Wan exchange a tense look.


EXT. SPACE - CORUSCANT

Slave 1 blasts out of hyperspace and toward the planet.


INT. SLAVE 1 - COCKPIT

Boba Fett guns the engines, tearing through the clouds.  Aurra
Sing comes up beside him, worried.

            AURRA SING
We weren't assigned to this, Lord
Tyranus --

            BOBA FETT
It's my ship, I'll do whatever I
want with it!

She looks at his angry face, nods.

            AURRA SING
All right.  I've got a little score
to settle with the Jedi, as well.


EXT. SPACE - CORUSCANT

Slave 1 streaks toward the surface.


EXT. CORUSCANT SKIES - DAY

An airspeeder carrying Mace Windu, Yoda, and Obi-Wan, who is at
the controls, hurtles in and out of the ceaseless traffic.
Yoda's shaken, trembling.

            YODA
A great disturbance there is in the
Force . . . something terrible I
fear has occurred.

            MACE WINDU
We'll be there in a --

                                                    74.

            OBI-WAN
Oh, my god . . .

They sit up.  In the distance, a thick pall of smoke rises above
the Jedi Temple . . .


EXT. JEDI TEMPLE - DAY

Amidst flames and smoke, platoons of Troopers attack the Temple.
Heavy machinery blasts the spires, creating EXPLOSIONS everywhere.
The ground's littered with bodies . . . Troopers, Jedi and
padawans.  Fires burn in the Temple.


EXT. CORUSCANT SKIES - DAY

Obi-Wan, Mace Windu and Yoda stare in horror.  Yoda's face
darkens in anger.


INT. JEDI TEMPLE - MAIN HALL - DAY

Plo Koon, bleeding, wounded, his robes torn, cuts down Troopers.
A blast from a SPHA-T EXPLODES nearby, sending debris flying,
knocking him down.

Plo Koon gets up with difficulty, retrieves a fallen Jedi's
lightsaber, and fights, one blade in each hand.  For each
Trooper that falls, a dozen more take his place.


EXT. CORUSCANT SKIES - DAY

Obi-Wan puts the speeder into a dive toward the Temple.

            YODA
Obi-Wan --

            OBI-WAN
We can't leave them to die!

The speeder hurtles toward the battle.


EXT. JEDI TEMPLE - DAY

The Clone Commander looks up, activates his commlink.

            CLONE COMMANDER
Units three-seven-seven and four-
one-eight -- incoming!

                                                    75.

A dozen two-man speeders converge, fire withering blasts at the
speeder.


EXT. CORUSCANT SKIES - DAY

The speeder's buffeted by near-misses.  Mace Windu grabs Obi-
Wan's arm as Yoda uses the Force to shield them.

            MACE WINDU
Watch out for that --

            YODA
Hold on!

Obi-Wan fights with the controls.


EXT. JEDI TEMPLE - DAY

AT-ATs also fire at the dodging speeder.  A particularly near
miss almost knocks it out of the air.

            CLONE COMMANDER
Don't let them get away!


EXT. CORUSCANT SKIES - DAY

Obi-Wan barely evades the deadly blasts.  Yoda leaps up onto the
rear of the speeder and ignites his lightsaber.  He deflects
bolts back, blowing up several of the attacking speeders.

            MACE WINDU
There's nothing we can do!  It's
too late!

Obi-Wan's torn with anguish and indecision.  A blast rocks them.
He pulls up, and speeds away.  Yoda looks back sadly.


EXT. JEDI TEMPLE - DAY

The Clone Commander eyes the departing speeder, activates his
wrist commlink.


EXT. CORUSCANT SKIES - DAY

The speeder hurtles toward the huge spaceport.  Two TIE
prototypes drop out of the sky onto its tail, firing laser bolts
at the little ship.

                                                    76.

The Jedi look back as the interceptors gain on them.  Obi-Wan
puts the tiny ship through its paces, but he can't shake them.

Yoda jumps onto the rear, using his lightsaber to deflect blasts.
A near miss blasts off a piece of the fuselage, almost knocking
Yoda out of the ship.

They're in open air approaching the spacedock.  The interceptors
close, firing.  Suddenly -- a shadow eclipses the sun
momentarily --

A battered, saucer-shaped (and strangely familiar) Corellian
freighter swoops between the interceptors and their prey.
Gattling lasers blast the first TIE to bits.

As the Jedi watch, it turns in a tight arc and bears down on the
second TIE.  It attempts to evade the freighter, and rams into a
tower, EXPLODING.

As the wary Jedi watch, the freighter comes into position above
them.  The hatch opens, and a ramp lowers.

            YODA
An invitation this seems to be.

            MACE WINDU
Maybe we'd better accept.  I don't
think we'll get a better offer today.

They transfer with a little difficulty from the speeder to the
ramp, Obi-Wan abandoning the controls at the last moment.  As
the speeder falls away, they enter the ship.


INT. CORELLIAN FREIGHTER - COCKPIT

They enter warily.  In the pilot's chair, CAPTAIN CALRISSIAN, a
black, hard-eyed smuggler/pilot throws the ship into a hard turn.

            CALRISSIAN
Are the others far behind you?  We
may need to --

            YODA
No more will there be.

Calrissian reacts, stunned.

            CALRISSIAN
Those ######## . . .

            OBI-WAN
I don't mean to sound ungrateful,
but --

                                                    77.

            CALRISSIAN
Calrissian.  Organa sent me.
Thought you might need a little
help, and I owed him a favor or two.

A couple of laser blasts shake the ship.  They look out the main
viewport.  Six TIE interceptors rise toward them.

            CALRISSIAN
Hang on to yer assets.


EXT. CORUSCANT SKIES - DAY

The battered freighter streaks into the stratosphere, quickly
outdistancing the interceptors.


INT. JEDI TEMPLE - MAIN HALL - DAY

Plo Koon, Eeth Koth, and Adi Gallia fight desperately.  Jedi and
Clone bodies lie everywhere.  Plo Koon looks up, exhausted and
bloody.

An AT-ST fires in their direction.  Eeth Koth tries to protect
several wounded Padawan.  They're all killed by its deadly bolts.

Plo Koon slices through Troopers.  He leaps straight at the AT-
ST driver sticking out of the hatch, slices through him.

Plo Koon lands hard on the ground, winded.  Two AT-ST walkers
emerge from the smoke and fire on the Jedi Master.  He leaps
aside, but an armored figure rockets in, jetpack blazing, and
nails him.

            PLO KOON
Yaaaagh -- !

He looks up from the ground, unable to rise.  Boba Fett steps up
and shoots him again.

Adi Gallia and a dozen wounded, exhausted Jedi fight back-to-
back.  Adi Gallia looks up.

In a window, a group of initiates, all under ten years old,
huddle with Nana Dorde as the ominous war machines approach,
blasting everything in sight.

            ADI GALLIA
No!

Adi Gallia fights her way toward the initiates, felling Troopers.
Boba Fett swoops down from above, firing.  Adi Gallia deflects
the blasts, but is attacked by Aurra Sing.

                                                    78.

They battle with lightsabers until Boba Fett shoots Adi Gallia
in the back.  With a strangled cry, she falls.  She looks up and
sees AT-ATs open fire on the Temple.  A moment later, Aurra Sing
steps into her line of sight, her lightsaber raised . . .


EXT. SPACE - CORUSCANT

The Corellian freighter speeds away.  A Star Destroyer appears
from the planet's netherside.


INT. CORELLIAN FREIGHTER - HOLD

The Jedi are subdued, stunned.  Obi-Wan's hand tightens on his
lightsaber.

            YODA
Your anger must you release, Obi-
Wan.  Dangerous to hold is it.

            OBI-WAN
It's not that easy!

            MACE WINDU
Master Yoda is right.  It will not
serve you, my friend.  How many
allies do we have left in the Senate?

            OBI-WAN
Very few.  Padmé -- we must warn her.

            YODA
Uhm, yes, protected must the unborn
Skywalker be.

            MACE WINDU
You still think it will make a
difference?

            YODA
That I can say not.  However, few
choices do we have.  Consider, must
we, all our possibilities.

Obi-Wan starts toward the cockpit.  Yoda watches him, troubled.


EXT. SPACE

The freighter speeds away from Coruscant.  The Star Destroyer
closes relentlessly, dwarfing the smaller vessel.

                                                    79.

INT. CORELLIAN FREIGHTER - COCKPIT

Obi-Wan, Yoda, Mace Windu and Calrissian face a hologram of SIO
BIBBLE.

            SIO BIBBLE
Obi-Wan --

            OBI-WAN
I must speak with Padmé.  It's
very --

            SIO BIBBLE
She's been kidnapped.

            OBI-WAN
Kidnapped?!  When?  How did it --

            SIO BIBBLE
We received a distress signal from
her transport.  By the time we
reached their co-ordinates . . .

            MACE WINDU
They're making sure we can't get
her to influence Anakin.

            OBI-WAN
Anakin.  He'll have to be told.  I
don't --

The ship shudders from an impact, cockpit ALARMS go off.
Calrissian moves to the controls.

            CALRISSIAN
We've got company.

He slides into the pilot's seat, Obi-Wan takes the navigator's
position, they charge up the deflectors.

            MACE WINDU
Nothing can outrun those big ships.

Calrissian gives him a self-assured smile.

            CALRISSIAN
Oh, yeah?


EXT. SPACE

The Star Destroyer closes on the freighter, firing.  Just as it
overtakes them -- the tiny freighter blasts into hyperspace.
Something very familiar about this ship.

                                                    80.

EXT. PLANET PYRRONNUS - DAY

A large, volcanic world torn by eruptions.  Towering cones belch
magma toward heavy cloud cover.  Carved out of a cliff is the
forbidding Sith fortress.  Bat-winged CREATURES sail around its
craggy summit.


INT. SITH FORTRESS - DETENTION CELL

Padmé stirs groggily, holds her head, slightly ill.  The door
opens, and two Troopers enter.  She looks at them with little
more than empty bravado.

            PADMé
I'd say you won't get away with
this, but you probably already know
that.

They haul her off the bare cot, and drag her out.  She struggles
weakly.


INT. SITH FORTRESS - LABORATORY

They drag Padmé into the red-lit chamber.  She recoils, her eyes
drawn involuntarily to the evil-looking machines.  SCREAMS echo
as dozens of prisoners are subjected to electronic torture.

Interrogation droid IG-666 watches an iron-maiden type device,
its eye sensors glowing.  The spindly droid is enjoying its work.

The device opens, emitting dense clouds of steam.  Threepio's
raised from a glowing cradle, his metallic body smoking.  There
are dozens of sinister-looking implants in his face.

            THREEPIO
Oh -- oh, my -- oh, what have I
done!?  Oh, mercy -- have mercy on
my poor circuits!

            IG-666
Louder, you pathetic protocol droid.
I love it when my subjects plead
for their useless lives.

            THREEPIO
Oh!  You horrible --

He's lowered toward the cradle by the CACKLING droid.  Padmé
struggles to pull free.

            PADMé
No!  Stop it!  Stop!  Leave him --

                                                    81.

She stares in horror as a large, black globe floats toward her,
nasty-looking needles and probes sticking out of it.  It floats
to within inches of her face, she sees her frightened reflection
in the gleaming surface.  Slowly, a wicked-looking needle extends.

            IG-666
Don't worry, we have plenty of
devices . . . no waiting.

He barks an ELECTRONIC LAUGH.  Padmé shrinks back against her
captors, who hold her firmly in place.  In the background,
Threepio WAILS piteously.  The heavy shield door to the
laboratory SLAMS down!


EXT. ALDERAAN - DAY

The Corellian freighter touches down on a landing pad in a blast
of retros.  Vast grasslands stretch into the distance, seamlessly
integrated with small villages.  Starships take off and land in
a constant flow.

Obi-Wan, Mace Windu, and Yoda descend the ramp toward a large
landspeeder where Bail Organa and two AIDES meet them.  Organa
is immensely relieved.

            BAIL ORGANA
I'm glad you made it safely.

            MACE WINDU
Our thanks for your timely
intervention, Viceroy.

            BAIL ORGANA
I only wish I could have done more.
Do you think there are any other
survivors?

Yoda closes his eyes in pain.

            OBI-WAN
Padmé's been abducted.  We must
locate her.

            BAIL ORGANA
Probably bounty hunter scum.  (to
an Aide) Get our people on it
right away.  (to the Jedi) Come.
We'll see what we can do.

They get into the landspeeder.  In the background, a herd of
NERFS grazes contentedly.

                                                    82.

INT. CORUSCANT - PADMé AND ANAKIN'S APARTMENT - NIGHT

Anakin meditates, restless.  He convulses in pain, sees a flash
of --


EXT. PYRRONNUS - NIGHT

The tortured world seethes in its volcanic throes --


INT. SITH FORTRESS - LABORATORY

-- Padmé strapped to a sinister-looking table, surrounded by
dark machines.  She cries out in pain and fear --


INT. CORUSCANT - PADMé AND ANAKIN'S APARTMENT - NIGHT

Anakin's eyes snap open --

            ANAKIN
PADMé!

He jumps to his feet, shaken as several glass items SHATTER
around him.  Artoo rolls in, BEEPING a blue streak.

            ANAKIN
Whuh -- Artoo.  Not now!  What --

Artoo BEEPS excitedly, whirls in a circle, and heads toward the
living room.  Anakin follows a moment later.


INT. LIVING ROOM AREA - NIGHT

Anakin enters to see a hologram of Obi-Wan shimmering in the
darkened room.

            ANAKIN
You.  What do you --

            OBI-WAN
I must speak with you.

            ANAKIN
It's Padmé -- she's in danger,
isn't she?!  That's why you
contacted me, isn't it?!  Tell me!

            OBI-WAN
Calm yourself, this won't help.
You must come to Alderaan as
quickly as possible.

                                                    83.

            ANAKIN
Alderaan!  That's not where she is!

Anakin's hands clench angrily at Obi-Wan's image.

            OBI-WAN
I can't explain now, I'll inform
you fully when you arrive.  And
don't tell Chancellor Palpatine.

            ANAKIN
Why not?  I trust him, maybe he can
help.

            OBI-WAN
You once trusted me.  I realize we
seldom see eye-to-eye any more, but
I'm asking you to do so again.

Anakin seethes a moment, then nods reluctantly.

            ANAKIN
All right.

He storms out.  Artoo follows, BEEPING.


EXT. SPACE - CORUSCANT

Anakin's starfighter streaks away from the planet.  It hooks up
with an orbiting jump ring, and blasts into hyperspace.


INT. JEDI TEMPLE - DAY

A heavy pall of smoke rises into the sky.  Thousands of Troopers
move through the blasted, ruined building, searching.  Blackened,
burned bodies lie everywhere, including children, the youngest
Jedi acolytes.


EXT. ALDERAAN - CASTLE LANDS - DAY

Anakin's starfighter settles beside a range of towering hive-
like structures that extend along the multi-colored grassland.
He emerges, still angry.  Obi-Wan is waiting for him.

            OBI-WAN
Come with me, we haven't got a lot
of --

He starts to go into the nearest hive.  Anakin doesn't move.
Obi-Wan turns and regards him a moment.

                                                    84.

            OBI-WAN
Please.

Anakin follows him up a natural stone stair into the nearest
hive-structure.


INT. KILLIK HIVE - DAY

Anakin and Obi-Wan enter.  The structure's design suggests it
was built by an intelligent insectoid race.  There are numerous
honeycomb chambers, and a large open space where Yoda, Mace
Windu, and Bail Organa wait.

            ANAKIN
You said you would help me find
Padmé.  Why are we wasting time here?!

            MACE WINDU
The Temple was attacked by
Palpatine's Clone Troopers.

Anakin shows no flicker of expression.

            MACE WINDU
You don't seem surprised.

            ANAKIN
What about Padmé?

            OBI-WAN
She has been captured by bounty
hunters.

Anakin's hand fastens on his lightsaber.  Yoda's eyes narrow.

            ANAKIN
And you're not going to help her?!

            MACE WINDU
Use your head.  Look around you.

Anakin regards them with deep disgust.

            ANAKIN
Chancellor Palpatine was right.

He turns, and finds Yoda blocking his way.  Anakin starts
forward, then hesitates.  Yoda regards him calmly.

            YODA
All alone would you rescue her, hmn?
Most extraordinary must you be,
Anakin Skywalker.

                                                    85.

            ANAKIN
Why?  Because I'm not afraid?

            YODA
No, because reckless and unthinking
are your actions, foolish and
irresponsible are your thoughts.  A
Jedi do you call yourself, mmm?

Anakin glares at Yoda a moment, then turns away.

            YODA
So typical is this behavior.
Heedless, unprepared would you rush
in?  Sacrifice all in the heat of
passion, would you?  A true Jedi
does not these things.

            OBI-WAN
We are four against an army of
hundreds of thousands.  Would it
serve Padmé to throw away our lives?

            MACE WINDU
You complain that we don't treat
you like a Jedi.  Well, it's time
you started to act like one.  Our
ways, our laws, they've been handed
down over thousands of years --

            ANAKIN
Maybe it's time for new ones!

            YODA
Time is it?  Huh!  What know you of
time?  Eight hundred and eighty
three years have I lived, and still
know I nothing of time.  Hmph!
Reckless, you are, and dangerous.

Anakin bristles.

            YODA
Hear you nothing of what we say?
To an end has come a great
tradition.  All but gone now are
the Jedi.  Soon, perhaps, only
darkness will the Force encompass.

Anakin moves forward.  Yoda raises a hand, for a moment they
strain their wills against each other, then Anakin staggers back.
He looks into Yoda's eyes, seething.

                                                    86.

            YODA
Mmm, yes, such a tragic waste, this
is.  Much power do you possess,
Anakin Skywalker, but much anger do
you retain, also.  To the dark side
will it lead you, and destruction.

            ANAKIN
I won't abandon her.

            MACE WINDU
Nor will we.

Anakin looks at him, doubtful.

            OBI-WAN
We are waiting for support troops
to arrive, then --

            ANAKIN
She may be dying.  I saw --

            YODA
A trap, by Darth Sidious was it
laid.  Your power does he covet,
for a powerful ally would you be.

Obi-Wan puts a hand on Anakin's shoulder.

            OBI-WAN
We will help her, I promise you.

Anakin looks from one to the other of them.  Finally, he nods
sullenly.

            ANAKIN
I swear, if anything happens to her
. . .

He stalks out.  Artoo BEEPS a worried query.

            MACE WINDU
What do you think?

            OBI-WAN
I have a bad feeling about this.


EXT. PYRRONNUS - SITH FORTRESS - NIGHT

The skies are red with constant eruptions.

                                                    87.

INT. SITH FORTRESS - DETENTION CELL - NIGHT

The door opens, two Troopers drag Padmé in and toss her roughly
onto her cot.  She's haggard, in pain.  Aurra Sing enters and
goes to her, lifts Padmé's tear-streaked face.

            AURRA SING
So, this is the great hero and
leader of Naboo, is it?

Padmé tries to rise, Aurra Sing shoves her back onto the cot.
She exits, laughing derisively.  Padmé curls up in a ball,
shivering.  Though she fights it, she begins to weep.


EXT. ALDERAAN - CASTLE LANDS - DAWN

The rising sun bathes the hives in golden light.


INT. KILLIK HIVE - DAWN

Yoda and Mace Windu look up as Obi-Wan enters.

            OBI-WAN
He's gone.

            YODA
Expected as much, I did.  Beyond
our help now is he.

            OBI-WAN
I'm going after him.

            YODA
How will you find him?

            OBI-WAN
I placed a homing beacon in his
ship last night.  Artoo will lead
me to them.

            YODA
Careful must you be, Obi-Wan.  No
help will we be able to give you.

            MACE WINDU
In addition to the Clones, you'll
be walking into a stronghold with
at least two Sith.

                                                    88.

            OBI-WAN
I'm hoping they won't expect me
this soon.  I know . . . it isn't
much . . . but it's the best we've
got.

He heads out.


EXT. ALDERAAN SKIES - DAY

Obi-Wan's starship streaks away from the blue-green planet.


EXT. CORUSCANT - MAIN SECTOR - DAY

The Senate Complex is awash in military speeders, heavy
equipment, and thousands of Troopers and war machines.


INT. CHANCELLOR'S OFFICES - DAY

The Clone Commander enters and salutes Palpatine who sits on a
floating throne-like chair.

            CLONE COMMANDER
We suffered heavy casualties, sir,
but we destroyed most of the Jedi.

            PALPATINE
Most of them?

            CLONE COMMANDER
A -- small group escaped, but we
will --

            PALPATINE
Yes, I should think you would.
That will be all Commander.  You
may return to your duties.

The Commander salutes and exits quickly.  Palpatine activates a
control on his throne, and a hologram of Dooku appears.

            PALPATINE
I am ready for your report, Lord
Tyranus.

            DOOKU
The tests confirm that Lady
Skywalker is with child, my Lord.

                                                    89.

            PALPATINE
As I suspected all along.  That was
their contingency plan, should
Skywalker fall to the dark side.

            DOOKU
We must destroy it.  And her.

Palpatine chuckles, shakes his head.

            PALPATINE
In due time, Lord Tyranus, in good
time.  For now, I have . . . other
plans for Lady Skywalker.

He chuckles evilly.


INT. SITH FORTRESS - DETENTION CELL - DAY

Padmé lies on her cot, miserable as large slimy VERMIN scuttle
around the dirty cell.  Dooku, Aurra Sing and four Troopers
enter.  Padmé shrinks back from the dark lord's intense gaze.

            DOOKU
How are we feeling, my lady?

            PADMé
Was that the worst you could do?

He takes her face in one hand.  She tries to pull away, but
can't.  Aurra Sing purrs in the background.

            DOOKU
We had to be thorough.  Though, to
answer your question -- no, it is not.

            PADMé
Is this where I tremble with abject
fear?

His eyes burn into hers, she returns the look defiantly.  Dooku
chuckles, and releases her.

            DOOKU
Such an indomitable spirit.  What a
shame we will have to crush it.

            PADMé
When am I to be executed?

                                                    90.

            DOOKU
Oh, you do us an injustice.  As
much as the late Viceroy Gunray
would have wanted to kill you, we
have decided to keep you alive.
For now.

            PADMé
Why?

            DOOKU
Let us say that you hold something
that my master is very interested in.

            PADMé
Darth Sidious?  Or is he still
going by the name Palpatine?

            DOOKU
Your insight serves you well, my
child.  Yes, the time is almost
ripe to drop the charade and reveal
himself.  Don't worry, we will see
to it that you are present to enjoy
the moment.

            PADMé
The Jedi will have something to say
about that.

            DOOKU
The Jedi.  Ah, yes.  No one has
told you?  Then it falls to me to
be the bearer of ill news.  The
Jedi, I am afraid, are no more.

            PADMé
I don't believe --

            DOOKU
Oh, it's quite true.  By now,
they've all been annihilated by
Lord Sidious' armies.

Padmé reacts with dismay before she can catch herself.  Dooku
nods, satisfied that they've gotten to her.

            DOOKU
Well, it's been pleasant.  We'll
chat again, later, hmn?  Oh, should
you require anything . . .

She looks away, shivering.  Dooku chuckles and exits.  Aurra
Sing looks at Padmé in disgust, and exits with the Troopers.

                                                    91.

INT. SITH FORTRESS - CORRIDOR - DAY

Aurra Sing joins Dooku.  Two Troopers take up guard positions
outside Padmé's cell.

            DOOKU
We are very grateful to you, my
dear, for delivering our guest.

            AURRA SING
A pleasure, Lord Tyranus, courtesy
of Jabba the Hutt.

            DOOKU
As per our agreement, Tattoine is
his, to do with as he will.

            AURRA SING
He will be pleased.

Boba Fett marches up, and spares Dooku a short glance.

            BOBA FETT
The ship's ready, Aurra.

She affectionately ruffles his hair.  There's obviously a
connection between them.

            AURRA SING
Young Fett tracked the Naboo ship
despite their precautions, my lord.
His skills are almost the equal of
his father's.

Boba Fett's face tightens.

            DOOKU
Do not fear, the Jedi who slew your
father survived the massacre.

Boba Fett looks up eagerly.

            DOOKU
We are expecting him to join us
shortly.  When he does, he will be
yours.

Boba Fett bows in gratitude.  With a last look at Aurra Sing, he
moves off down the corridor.

            DOOKU
Life is so simple for the young.
No thoughts beyond satisfying their
most basic urges.

                                                    92.

            AURRA SING
You're certain they'll come, Lord
Tyranus?

            DOOKU
Oh yes.  Skywalker will come for
her, they will come for him.  They
are so distressingly predictable.


EXT. SPACE

Anakin's starfighter detaches from its jump ring, and streaks
toward Pyrronnus.


INT. ANAKIN'S STARFIGHTER - COCKPIT - MOVING

He anxiously peers at the raging world as they descend through
thick, red-lit clouds.  In the navigation module, Artoo BEEPS.

            ANAKIN
Are you picking up any life forms?

Artoo BEEPS an affirmative.

            ANAKIN
Lock in on them.  I'm going in.

Artoo BEEPS and CHATTERS, his dome swiveling.


EXT. SPACE

Anakin's starship streaks toward the surface.


EXT. PYRRONNUS - DAY

Towering, jagged mountains rise around a cracked plateau
surrounded by rivers of molten lava.  Anakin climbs down from
his ship.  Large fissures vent super-heated steam.  Artoo starts
to rise out of his module.

            ANAKIN
No, stay here.

Artoo BEEPS doubtfully.  Anakin sets off across the barren,
volcanic landscape.  Strange salamander-like CREATURES lurk in
the crevices, shifting the scintillating colors of their bodies.

The SOUND of a starship ENGINE causes Anakin to look up.  Obi-
Wan's ship lands near his starfighter.  Anakin watches Obi-Wan
emerge and walk toward him.

                                                    93.

            ANAKIN
You just don't get it, do you?

            OBI-WAN
I'm trying to stop you from making
a terrible mistake.

            ANAKIN
Just stay out of my way.

He starts off.  Obi-Wan grabs his arm, Anakin cuffs him aside.

            ANAKIN
I said --

            OBI-WAN
Don't be a fool, Anakin, you can't
do this alone!

            ANAKIN
I don't need you -- any of you!
All you've ever done is hold me back!

            OBI-WAN
You know that isn't true.

            ANAKIN
Isn't it?!  You've never understood
my true feelings -- you never even
cared to.

            OBI-WAN
Because I tried to teach you
discipline?  A Jedi needs discipline.
Padmé understood --

            ANAKIN
And you used your mind tricks to
turn her against me!

He starts off.

            OBI-WAN
It's the Sith who are preying on
your mind.  The dark side is trying
to engulf you, that's why they're
using her.

Anakin turns slowly to face Obi-Wan, his face twisted with anger.

            ANAKIN
What's so bad about the dark side?
Have you any idea of its power?
I'm beginning to enjoy using it.

                                                    94.

            OBI-WAN
You don't mean that!  You can't --

            ANAKIN
After my mother died -- was
killed -- I swore I would never
again allow someone I loved to die
because of my not taking action.

            OBI-WAN
She isn't going to --

            ANAKIN
I slaughtered the entire tribe of
sandpeople who killed her.  And I
enjoyed it.

He turns, but Obi-Wan grabs him.  Anakin swings at him, then
ignites his lightsaber.  Obi-Wan backs off, shocked.

            OBI-WAN
This path will lead to your
destruction . . . and the
destruction of those you seek to
protect.

            ANAKIN
I've had enough of your lies!

            OBI-WAN
This won't help Padmé, she --

Anakin attacks.  Obi-Wan's lightsaber leaps into his hand, he
parries Anakin's attacks, retreating to keep from injuring his
friend.

Anakin becomes frustrated that he can't cut Obi-Wan down.  He
grows more powerful with his rage, and Obi-Wan is hard-pressed
to avoid the deadly blade.

They leap across erupting fissures, battling fiercely.  Around
them the planet's volcanic activity increases, as though it were
part of their battle.

            OBI-WAN
Anakin -- listen to me --

            ANAKIN
NO!  No more lies!

Obi-Wan almost gets cut in half.  He teeters on the edge of a
precipice, the rocks crumbling under his feet --

Below, a fiery river seethes --

                                                    95.

Anakin leaps -- Obi-Wan deflects his blows and flips up and over
him to safety.  Blind with rage, Anakin charges after him.  The
battle takes them up a ridge along the cliff face.


EXT. PYRRONNUS - LAKE OF FIRE - DAY

A squad of Troopers riding large, bipedal dragon-like TARKS
equipped with saddles notice the flashes on a nearby plateau.

            CLONE TROOPER
Come on, let's check it out.


EXT. PYRRONNUS - PLATEAU - DAY

Anakin presses Obi-Wan back savagely.  Lightsabers flash and
spark as the battle reaches a crescendo.  Anakin knocks Obi-Wan
against a rock outcrop with a kick.

He raises his weapon overhead -- brings it down -- Obi-Wan leaps
clear -- super-hot gasses erupt from the cleft rock, engulfing
Anakin, who cries out in pain.

            OBI-WAN
This is madness!  Stop!

Anakin staggers back, burned and blistered, beyond reason.

            ANAKIN
Prepare to meet the Force, Obi-Wan!

He attacks, Obi-Wan's blade clashes with his.  A TREMOR
fractures the ledge, knocking Anakin off-balance.  He drops his
lightsaber -- falls over the edge.

Anakin hangs from a ledge over a pit of molten lava by his
mechanical hand.

            OBI-WAN
Anakin!  Anakin -- hang on!

Obi-Wan tries to reach him.  Anakin hangs on desperately.  The
rock begins to fracture under his metal grip.

Anakin looks up into Obi-Wan's eyes.  Obi-Wan moves precariously
out over the molten abyss, reaching --

His fingertips scrabble at Anakin's hand.  Just as he reaches
the mechanical wrist -- a huge ERUPTION from below blasts the
ledge -- Obi-Wan recoils -- the rock crumbles!  With a SCREAM
Anakin plunges into the molten lava.

                                                    96.

            OBI-WAN
ANAKIN!!!

Below, magma bubbles and boils.  There's no sign of Anakin.


EXT. PYRRONNUS - OBI-WAN'S SHIP - DAY

The planet seethes and RUMBLES.  Strange, armored CREATURES
skitter across its surface.


INT. OBI-WAN'S SHIP - DAY

A stunned Obi-Wan faces a hologram of Yoda and Mace Windu.

            YODA
With you do we grieve, Obi-Wan.  A
terrible end is this.

            MACE WINDU
The support troops have arrived.
We'll be there shortly.

Obi-Wan stares at Anakin's lightsaber in his hand.  Yoda and
Mace Windu exchange a troubled look.

            YODA
Obi-Wan . . .

            OBI-WAN
Yes, Master Yoda, I know.  Do we
have enough men?

            MACE WINDU
We'll have to make do.  Stay under
cover until we arrive.  We can't
afford to lose you, too.

Obi-Wan nods, tears streaming down his face.  The holograms fade.
Behind him, Artoo BEEPS mournfully.


INT. SITH FORTRESS - DOOKU'S CHAMBERS - DAY

A Trooper salutes Dooku.  He looks up, irritated.

            CLONE TROOPER
Sir, we have recovered a badly-
burned body from the magma lake.

            DOOKU
A body?

                                                    97.

            CLONE TROOPER
It's still alive . . . barely.  We
think it may be Skywalker.

Dooku gets to his feet, shaken.  He hesitates.

            DOOKU
Take it to the medlab -- immediately.

The Trooper salutes and exits.  Dooku ponders this new
development.  He activates a control on his desk, a hologram of
Darth Sidious appears.

            DARTH SIDIOUS
A problem, Lord Tyranus?

            DOOKU
A boon, my master.  We have found
Skywalker.

            DARTH SIDIOUS
He is there?!  Why was I not informed?

            DOOKU
I have only just learned myself,
master.  I have had his body sent
to the lab.

            DARTH SIDIOUS
His -- !  What has happened?  Tell me!

            DOOKU
I'm not entirely certain yet, but
he's apparently still alive.

            DARTH SIDIOUS
See that he remains so.  It is vital.

            DOOKU
Why is this one so important?

            DARTH SIDIOUS
He is a powerful weapon with which
we will destroy the Jedi forever.

            DOOKU
Is that . . . the only reason?

Darth Sidious cackles gleefully.

            DARTH SIDIOUS
Put your mind at ease, my friend.
I will join you shortly.  See that
all is in readiness for my arrival.

                                                    98.

He cackles as Dooku bows.  Dooku's face shows signs of growing
unease.


INT. SITH FORTRESS - LABORATORY - DAY

Threepio, miserable in a metallic cage, sparking sensors
imbedded in his face, watches a multi-legged ARAKHNOT scuttle
across a gleaming metallic table, its sixteen red eyes glinting
in the harsh artificial light.

            THREEPIO
Oh!  Oh, my!  Shoo -- shoo, you
horrible -- oh, why was I made to
suffer so?  What did I ever --

He looks up, frightened, as a dozen spindly, BLACK DROIDS enter,
pushing an anti-grav container a few feet above the floor.

            THREEPIO
Oh, now what?  Oh, will this never
end?

The droids carefully lift Anakin's burned body out of a
container of cloudy bacta liquid.  Most of his skin is gone,
what's left is raw and scarred.  He moans and tosses fitfully,
gasping for breath.

            THREEPIO
Oh, my!  Master Skywalker!  Oh,
what are you doing to him?

They place him on a glowing table.  He's lowered into a sealed
glass sarcophagus filled with HUMMING machinery.  Pieces of
BLACK ARMOR are fastened to his body.  He's barely conscious,
delirious.  He tosses and moans.

A black, GARGOYLE-LIKE BREATH MASK descends over his scarred
head.  He twists his head, but it's held in place by padded clamps.

The breath mask is fastened to the armor.  On a chest plate,
sensor lights blink, then stabilize.  Anakin continues to toss
and moan in pain.  The tortured SOUND of his BREATHING becomes
more regular, controlled by the armor.

            THREEPIO
Oh, dear, oh, dear!  Master
Skywalker -- oh, master Skywalker --
can you hear me!  Can you -- oh!

A hologram of Darth Sidious' head shimmers into view, huge and
ominous.

                                                    99.

            DARTH SIDIOUS
Do not fear, my young friend, I am
here to help you.

Threepio huddles in his cage, trying to not be seen.

            THREEPIO
Oh, my . . .

            ANAKIN
. . . Padmé . . . where -- is --

            DARTH SIDIOUS
Quite near.  But she has been
imprisoned -- by Count Dooku.

            ANAKIN
-- no!  Padmé!  Padmé!

He tries to rise, but can't.

            DARTH SIDIOUS
I have saved your life, though
Count Dooku and the Jedi have
conspired to destroy you.

            ANAKIN
Obi . . . Obi-Wan . . .

            DARTH SIDIOUS
Wishes to see you dead.

            ANAKIN
No . . . tried . . . to save me . . .

            DARTH SIDIOUS
He desires that he and Padmé may be
together.

            ANAKIN
NO!  No . . . no . . .

            DARTH SIDIOUS
He would control your unborn
children . . . shape them to his
will.  There is only one way to
save them . . . and yourself.  You
must embrace the power of the dark
side!

Anakin tosses in torment, a tremendous inner struggle rages
within him.  Suddenly, he HEARS:

                                                   100.

            PADMé (VO)
Anakin!  Help me -- Anakin!

            ANAKIN
PADMé!!!  Padmé -- wait -- don't --

His struggles become stronger.

            DARTH SIDIOUS
YES!  That is it, my young
apprentice!  You must rise -- RISE
and take your place at my side!
Together, we will triumph!

As Threepio watches, anger and hatred course through Anakin,
renewing his strength.  With a powerful surge -- he comes to his
feet -- SHATTERING the sarcophagus with an elemental ROAR!

Glistening glass and twisted machinery fall away, revealing him
in black armor and grotesque breath mask.  The amplified SOUND
of his HEAVY BREATHING fills the room.

            THREEPIO
Oh, dear . . . this can't be a good
thing.

Anakin looks around and sees a lightsaber on a padded cushion
nearby.  He approaches, picks it up slowly, ignites it.  The
blade is red.

            DARTH SIDIOUS
It belonged to a former apprentice,
Lord Darth Maul.  He was slain at
Naboo fifteen years ago.

Anakin's VOICE is a powerful (and familiar) RUMBLE from deep
inside of him, amplified by the breath mask.

            ANAKIN
I . . . remember.  Obi-Wan . . .

He stares at the gleaming blade, its satanic light reflected in
his armored visage.

            ANAKIN
Obi-Wan . . . !


EXT. PYRRONNUS - DAY

Obi-Wan watches the Corellian freighter land.  Yoda, Mace Windu,
Calrissian and twenty scruffy CORELLIAN COMMANDOS emerge,
heavily armed.  They join Obi-Wan.

                                                   101.

            MACE WINDU
Master Yoda and I will handle Lord
Tyranus.  You and the others will
search for Padmé.

            YODA
Up to this are you, Obi-Wan?

            OBI-WAN
Yes.

            YODA
Not in vain will his, and the other
deaths be.  Still can we resolve this.

            OBI-WAN
Then let's get going.

His face is set with grim determination.  They move out.


INT. SITH FORTRESS - DAY

Dooku descends a flight of stairs.


INT. SITH FORTRESS - TRAINING HALL - DAY

He enters and looks around, sensing something.  He steps back as
a large FIGURE in black armor steps into view, and ignites its
blood-red lightsaber.

            DOOKU
Who . . . Skywalker?!

            ANAKIN
Where is Padmé?  What have you done
with her?

Anakin moves slowly toward him.  Dooku retreats.

            DOOKU
You -- she is alive!  I --

Anakin easily flings a heavy table across the room with one hand.
Dooku inches back.

            DOOKU
You -- you must calm yourself, my
friend, your --

The lightsaber whips up, pointed at Dooku's head.

                                                   102.

            ANAKIN
You sought to destroy me.  Defend
yourself.

            DOOKU
No!  You are mistaken!  I did --

Anakin slices a huge generator in half.  Dooku retreats into the
shelter of a large condenser unit.  A moment later -- Anakin's
lightsaber slices through it in a shower of sparks.

Dooku ignites his weapon and they battle.  Anakin is larger,
stronger, but Dooku's more skilled.  He manages to evade
Anakin's attacks.

            DARTH SIDIOUS (VO)
Excellent!  Excellent!

He steps out of the shadows, applauding.  Dooku looks to him
desperately.

            DOOKU
Master -- !

            DARTH SIDIOUS
Your journey toward the dark side
is almost complete, my young
apprentice.  Now, strike him down
with all your anger -- all your
hatred -- and take his place at my
side!

Anakin advances.

            DOOKU
NO!  Master!  I have served you
faithfully!  Why do you abandon me!
Master!

            DARTH SIDIOUS
Really, Lord Tyranus.  You of all
people should realize that only the
strongest may serve the dark side.

Anakin rushes toward him.  Dooku defends himself, but there's
fear in his eyes.  Darth Sidious watches, cackling gleefully.


EXT. SITH FORTRESS - DAY

A regiment of Troopers is on guard alongside speeders, light
assault vehicles.

                                                   103.

            CLONE TROOPER
What was that?

            CLONE TROOPER 2
I didn't hear anything.

            CLONE TROOPER
I'm sure it was --

The Jedi land on them with a vengeance, followed by the others.
Lightsabers slice through the startled Troopers, Calrissian's
men blast the others.  They run inside.  Artoo follows, BEEPING
excitedly.


INT. SITH FORTRESS - DAY

The two groups split up.  Obi-Wan leads his up a flight of stone
steps, and through an opening.  Mace Windu and Yoda battle
scores of Troopers.  They reach a dark chamber.  Yoda reels
slightly as Mace Windu cuts down the last of the Troopers.

            MACE WINDU
What is it?

Yoda looks toward the dark opening with a shiver.

            YODA
Great evil do I sense within.

            MACE WINDU
Sifo-Dyas.

They enter cautiously, their lightsabers providing eerie
illumination . . . . . .


INT. SITH FORTRESS - DARK CHAMBER

They peer into the blackness warily.

            DARTH SIDIOUS (OS)
Welcome, my brave Jedi!  Welcome . .
. to your doom.

He steps out of the darkness, and slowly drops his hood to
reveal Supreme Chancellor Palpatine.

            DARTH SIDIOUS
I have looked forward to this for
some time, Master Yoda.

Mace Windu starts forward, Yoda waves him back.

                                                   104.

            YODA
Blind have I been, blind and
stupid, not to suspect.

            DARTH SIDIOUS
You were blinded by the power of
the dark side.  There was nothing
that you could do.

            YODA
Think you that you have won?

            DARTH SIDIOUS
The old Republic is in its death
throes, a relic of a bygone age.
In its place will be the New Empire.

            MACE WINDU
Ruled by you.

            DARTH SIDIOUS
Unfortunately, my plans don't
include Jedi.  Alas.

            MACE WINDU
Perhaps we'll have something to say
about that.

The two Jedi masters ready themselves.  Instead of attacking,
Darth Sidious throws his head back and laughs.  The Jedi
exchange surprised looks.

            DARTH SIDIOUS
How ludicrously melodramatic.
There is something I should like to
show you, first.

Chuckling, he moves further into the chamber.  Yoda and Mace
Windu exchange a wary look.


INT. SITH FORTRESS - TRAINING HALL

The Jedi emerge cautiously on a ledge overlooking the main floor.
From below come the SOUNDS of a savage lightsaber duel.  They
look down.

Anakin and Count Dooku are locked in a magnificent battle
between two powerful, skillful opponents.  Their flashing blades
reduce the machinery in the room to scrap.

            YODA
No!  That -- is --

                                                   105.

            DARTH SIDIOUS
Anakin Skywalker.  Your final
gambit has failed!  He will take
Count Dooku's place at my side.

With a yell, Yoda attacks.  Darth Sidious, amused, parries
Yoda's Force bolts with his own.  Mace Windu rushes in, but
Darth Sidious sends him crashing into the rocky wall, engulfed
in crackling dark-side lightning.

Yoda and Darth Sidious' energy duel intensifies, as, below,
Anakin and Dooku clash savagely.


INT. SITH FORTRESS - TUNNEL

Obi-Wan, Calrissian and his men, and Artoo move through a low
tunnel.  Artoo BEEPS nervously.

            OBI-WAN
Shhh!


INT. SITH FORTRESS - GREAT HALL

They emerge cautiously.  Fifty Troopers rush out, and open fire.

            OBI-WAN
This way!

They blast away at each other.  Artoo BEEPS excitedly and rolls
down a connecting corridor.  Obi-Wan breaks off from the battle
and follows.


INT. SITH FORTRESS - OUTSIDE PADMé'S CELL

Obi-Wan cuts down the Troopers on guard.  He studies the access
pad a moment, then slices it in two with his lightsaber.  The
cell door opens.  Artoo BEEPS excitedly.

            THREEPIO (OS)
Oh -- mercy -- mercy!  Wait --
don't -- AAAHHHHHH!

Artoo wheels around and heads for the VOICE.


INT. SITH FORTRESS - DETENTION CELL

Padmé looks up to see Obi-Wan dash in.  She runs to hug him,
trembling.

                                                   106.

            PADMé
I thought you weren't coming.

            OBI-WAN
I took a wrong turn at Antares.
Come on.

He takes her hand, and they run into the corridor.


INT. SITH FORTRESS - CORRIDOR

Padmé scoops up a blaster.  She and Obi-Wan dash down the hall.
She blasts Troopers as they run.

            OBI-WAN
Artoo?!  Artoo, where are you?

They HEAR the little droid BEEPING.

            PADMé
Over there!

They dash on, Padmé firing her weapon into intersecting corridors.


INT. SITH FORTRESS - LABORATORY

Artoo dodges and parries with IG-666.  Threepio hangs in a
webbing-like mess of wires.

            THREEPIO
Oh, Artoo, be careful!  Watch out!

Artoo ducks through IG-666's legs, and extends a whirling buzz-
saw from a compartment.  It slices through the droid's leg
servos.  With an electronic SQUEAL, it falls.  Padmé blasts IG-
666 to SQUEALING scrap.  Artoo cuts Threepio free with his saw.

            THREEPIO
Careful -- oh, Artoo, I'm so happy
to see you!  You can't imagine --
wait -- watch out --

He crashes to the floor in a heap.  Obi-Wan and Padmé help him up.

            PADMé
Oh, watch it, don't -- hold still!
Threepio -- !

They help the struggling Threepio to his feet, still engulfed in
the wiring.

                                                   107.

            THREEPIO
Oh!  This is all your fault, you
mechanical lout!  You're trying to
kill me!

            OBI-WAN
Never mind that, come on!

They lead the woozy Threepio into the corridor.  Artoo follows,
BEEPING happily.

            THREEPIO
The very least you could do is help
me get these horrid things out of
my face -- oh!


INT. SITH FORTRESS - CORRIDOR

They emerge cautiously.

            THREEPIO
Oh, my -- I almost forgot!  Master
Sky --

SOUNDS of BATTLE come down the corridor.

            PADMé
Listen!

            OBI-WAN
We'd better see what that is.

            THREEPIO
What?!?  Are you mad?!?  We should
run for our li --

Padmé covers Threepio's speaker.

            PADMé
Shhh!  Shut up, will you?  You'll
get us all killed.

Artoo BEEPS in agreement.

            THREEPIO
Who asked you!  This is all your
fault.

            OBI-WAN
Go back to the ship and wait for us.

                                                   108.

            THREEPIO
Ship?!  There's a ship?  Hooray,
we're --

Obi-Wan and Padmé cover his speakers again.

            OBI-WAN
Just go with Artoo.  And be quiet.

They move toward the SOUND of LASER FIRE.  Artoo BEEPS
impatiently at Threepio.

            THREEPIO
I'll come when I'm good and ready,
you little --

Artoo makes a RUDE SOUND and wheels away.

            THREEPIO
Wait -- wait!  I didn't mean it!
Come back -- waaaaaait!

He hurries after the disappearing Artoo.


INT. SITH FORTRESS - TRAINING HALL

They creep in.  Dooku defends himself desperately.  A dozen
Troopers watch, along with Aurra Sing and Boba Fett.  Obi-Wan
stops, stunned, his face registers confusion.

            PADMé
Come on, we have to --

            OBI-WAN
That's . . . that's Anakin . . .

She looks at him sharply, then at the battle.  A commotion above
catches their attention.

On the balcony, Mace Windu tries to deflect Darth Sidious's
lightning attacks with his lightsaber.  He's hurled across the
room.  Yoda leaps between Darth Sidious and the wounded Mace Windu.

            DARTH SIDIOUS
You only prolong the inevitable, Jedi.

            YODA
Perhaps.  But too easy for you, we
do not wish this to be.

Darth Sidious chuckles and launches dark lightning.  Yoda meets
it with his own Force energy.  The powerful energies meet with a
blinding flash.

                                                   109.

Mace Windu looks up, groggy, as Yoda and Darth Sidious, almost
obscured by the powerful energies, attempt to broach each
other's defenses.


INT. SITH FORTRESS - CORRIDOR

Calrissian and his men are ambushed by fifty Troopers.  Many of
them men fall, the rest take cover and shoot back.

            CALRISSIAN
Damn clones!  Hurry, take them out!
We have to find the Jedi!

He ducks as a barrage of laser bolts EXPLODES in front of them.


INT. SITH FORTRESS - TRAINING HALL

Obi-Wan and Padmé watch the Anakin-Dooku duel.

            PADMé
What do you mean?  Where is Anakin?

She looks at Obi-Wan in dawning horror.  Slowly, her eyes turn
back toward the duel, dreading the realization that's growing on
her.

Dooku, on his knees, desperately fends off Anakin's powerful
blows.  He gestures wildly -- a large generator tears free and
hurls at Anakin.

Anakin gestures -- another generator unit flies free from its
moorings and SMASHES into the first.

Dooku tries to rise -- Anakin's lightsaber whistles out --
Dooku's head sails free of his body.

Obi-Wan and Padmé gasp in shock.

            PADMé
Anakin . . . ? !

Anakin's head snaps around, as Troopers' laser blasts rip toward
Obi-Wan and Padmé, the smoke from EXPLOSIONS momentarily
obscurring them.

Obi-Wan deflects the laserbolts with his lightsaber.

            OBI-WAN
Run, Padmé!  Run!

            PADMé
I'm not leaving you!

                                                   110.

A dozen Troopers advance, firing.  Aurra Sing and Boba Fett see
the commotion.

            AURRA SING
Come on.

They charge toward the battle.

Anakin starts toward the fight, looks up toward the ledge.  Yoda
and Darth Sidious hurl potent energies at each other.  Anakin
looks back to where Obi-Wan and Padmé fight the Troopers and the
bounty hunters, then he looks back up at the ledge.

Mace Windu crawls toward Darth Sidious.  Anakin looks again at
Padmé, and makes up his mind.  He runs -- and leaps -- jumping
from one huge piece of machinery to another --

-- and lands on the ledge.  He picks Mace Windu up, and hurls
him into the wall.  The wind knocked out of him, Mace Windu
slides to the ground.


EXT. PYRRONNUS - DAY

Artoo speeds toward the Corellian freighter as gasses vent from
underground fissures.  Threepio hurries to keep up.

            THREEPIO
Wait -- wait for me, you
insufferable little --

A large, scaly WIEROO rears up out of the steaming mud, HISSING.

            THREEPIO
Yaaaaaahhhh!  Oh -- Artoo --
Artoo -- help me!  Oh --

He rushes toward the ship.


INT. SITH FORTRESS - TRAINING HALL

Anakin advances on Mace Windu with his lightsaber.  Mace Windu
barely gets to his feet in time to block the powerful blows.

            MACE WINDU
Anakin -- Anakin -- don't -- you
mustn't --

With a roar of rage, Anakin presses the attack.

Yoda looks up from the fight, distracted.  Darth Sidious blasts
Yoda across the room with a powerful surge of Force lightning!

                                                   111.

Below, Obi-Wan looks up --

            OBI-WAN
Yoda -- !

Aurra Sing's lightsaber cuts across Obi-Wan's shoulder and thigh.
He cries out in pain and stumbles as she presses the attack.
Boba Fett charges them.

Padmé blasts Boba Fett.  His armor takes several hits, knocking
him aside.  Aurra Sing moves in on Padmé, lightsaber flashing.
Padmé fires desperately, but Aurra Sing deflects all the bolts.

On the balcony, Anakin's distracted -- Mace Windu desperately
slashes -- the blade cuts into Anakin's armor, making it spark.
He cries out in pain --

Below, Padmé flips and rolls as she fires her weapon.  Aurra
Sing counters her moves, the two of them moving like gymnasts.

Obi-Wan gets to his feet, but has to defend against a dozen
Troopers, hampered by his wounds.

On the balcony, Darth Sidious watches Anakin's gauntleted hand
close into a fist -- Mace Windu gasps for breath.  Mace Windu
slashes with his lightsaber -- Anakin smashes it out of his grip.
Using the Force, Anakin lifts Mace Windu off his feet, strangling
him.

            DARTH SIDIOUS
Yes, my young one.  Feel the hatred
welling up within you.  Now use
that hatred -- use it!

Yoda appears in the entrance, battered, wounded.  He raises a
hand --

Anakin snarls in anger, and opens his fist.  Mace Windu shoots
up -- and is impaled on a jagged stalactite on the ceiling.

Yoda cries out in despair.

Below, Padmé lands awkwardly and falls.  Aurra Sing lands in
front of her -- slashes Padmé's blaster, making it EXPLODE.
Padmé retreats as Aurra Sing moves in on her.

Obi-Wan disposes of the last Trooper.  He sees what's happening.

He flings his lightsaber -- Aurra Sing turns -- Padmé dives into
a forward roll -- comes up with a blaster -- and nails Aurra
Sing -- as Obi-Wan's lightsaber slices through her body.

She crumples to the floor.  Padmé rises slowly, battered and
bloody, her blaster smoking.

                                                   112.

She staggers to Obi-Wan, barely manages to keep him from falling.

On the balcony, Darth Sidious hurls a powerful energy barrage at
Yoda, but Yoda deflects it.  The resulting EXPLOSION brings down
the cavern wall, cutting him off from Darth Sidious and Anakin.

Below, Padmé struggles to help Obi-Wan stay on his feet.

            PADMé
Anakin . . .

            OBI-WAN
We have to go . . . Padmé, it's too
late.  We cannot help him.

She looks up toward the balcony.  She slips Obi-Wan's arm around
her shoulder, and helps him out.

On the balcony, Darth Sidious approaches Anakin.

            DARTH SIDIOUS
Well done, my young apprentice,
well done.  Your powers are now
complete.

Anakin kneels.

            ANAKIN
I am honored, my master.

            DARTH SIDIOUS
But you are also troubled.  What is
it?  Speak.

            ANAKIN
Padmé . . . I cannot sense what has
happened to her.

Darth Sidious' face darkens, then he smiles craftily.

            DARTH SIDIOUS
I fear that she has perished.

Anakin's head comes up.

            DARTH SIDIOUS
The Jedi slew her while I battled
with Yoda, I could do nothing.  I
am sorry.

Anakin rises slowly.  His huge frame trembles with barely
restrained fury.

                                                   113.

            ANAKIN
For this, I swear I will destroy them!

Darth Sidious smiles, puts a hand on Anakin's shoulder.

            DARTH SIDIOUS
Anakin Skywalker cannot.  He is
weak.  You must do away with him
first.

Anakin flexes his gauntleted fingers.

            ANAKIN
Yes.  That name has no meaning for
me now.

            DARTH SIDIOUS
Indeed.  From this moment, you
shall be reborn . . . welcome --
Darth Vader, Lord of the Sith!


EXT. PYRRONNUS - DAY

Obi-Wan and Padmé struggle toward the ship.  They're joined by
Calrissian, six of his men, and Yoda, who's somewhat the worse
for wear.

            CALRISSIAN
You made it --

            PADMé
We've no time for congratulations,
Captain, we have to --

A blistering fusillade of laser bolts drives them to cover.
They peer out from behind sheltering volcanic rock.  Twenty
Troopers have them pinned down.

            PADMé
C'mon, let them have it!  We have
to reach the ship!

They fire back.  Obi-Wan struggles to rise, but Yoda gently
pushes him back down.

            YODA
Your strength must you conserve,
Obi-Wan.  Not yet over is this.

The firefight rages, bits of rock EXPLODING all around.  Yoda
turns toward the freighter, shuts his eyes --

                                                   114.

INT. CORELLIAN FREIGHTER - COCKPIT

Threepio and Artoo, on pins and needles, HEAR the OS FIREFIGHT.
Artoo BEEPS frantically, starts for the hatch.

            THREEPIO
Wait a minute, where are you going?
What?  (off Artoo's excited BEEPS)
Where?  Out there!?!  You're mad!
Mad!  You'll be disintegrated!
Don't be a ninny!

He blocks Artoo from leaving the ship.  The little astro-droid
BEEPS and WHISTLES a blue streak.

            THREEPIO
Don't take that tone with me, you
cantankerous little tub of
mismatched parts, I'm not letting
you go out there.  It's more
important to stay here and protect
me!  You'll thank me for this one day.

Artoo BEEPS and WHISTLES angrily.  He spins around and rolls
toward the controls.

            THREEPIO
You watch your language!  After
all -- wait a minute, what are you
doing?  Stop that!

Artoo inserts probes into several consoles.

            THREEPIO
Hey, you're not supposed to do
that, you're an astromech droid!
You'll be deactivated if they catch
you -- oh, my!

He's staggered as the ship's cannons detonate --


EXT. PYRRONNUS - DAY

-- blasting several Troopers to bits.  The others are distracted
long enough for Calrissian and his men to pick them off.

            CALRISSIAN
That's it!  Make for the ship, now!

They run for the ship, firing at pursuing Troopers.  Four
Troopers on Tarks chase them, shooting.

                                                   115.

INT. CORELLIAN FREIGHTER - COCKPIT

Artoo BEEPS angrily and inserts a probe into a console.

            THREEPIO
Oh!  Stop -- Stop!  You'll blow us
all up, you little refurbished nitwit!


EXT. PYRRONNUS - DAY

The ship's gattling lasers unhouse and open fire -- blasting the
pursuing Troopers.  Our heroes reach the hatch.


INT. CORRELIAN FREIGHTER - COCKPIT

They enter and slam the hatch.  Calrissian fires up the engines
as Padmé helps Obi-Wan out of the cockpit.

            THREEPIO
Oh, Artoo, I knew you'd do it!
Hooray!!!

            CALRISSIAN
Better strap in!  Here's where the
fun begins --


EXT. PYRRONNUS - DAY

The freighter rises abruptly and blasts off into the clouds.
Troopers fire shots that bounce off her hull.


INT. CORRELIAN FREIGHTER - COCKPIT

Artoo HOWLS as he slides backward across the deck, and through
the entryway into the companionway.

            THREEPIO
Oh, my -- YAAAAAAAA!  I HATE SPACE
TRAVEL!

He flies backward and slams into a bulkhead.


EXT. SPACE

The freighter streaks for open space.  Three Star Destroyers
chase them in hot pursuit.

                                                   116.

INT. CORRELIAN FREIGHTER - COCKPIT

Calrissian shoots a worried look at his flashing scopes.

            CALRISSIAN
We've got company.  Better angle
the deflectors!  Charge up the main
guns!

His men hurry to comply.  Yoda peers at the scopes.


INT. CORRELIAN FREIGHTER - CARGO HOLD

Obi-Wan sits while Padmé tends his wounds.  She looks at him,
and he looks away.  She watches him a moment, then gently takes
his hand in hers.  He looks up at her.

            PADMé
This is not the time to shut our
allies out, Obi-Wan.  When we were
attacked, I . . . I felt helpless,
also.  When they killed Jar Jar . . .

            OBI-WAN
I'm sorry.  He was a good companion.

            PADMé
And a good friend.  But there was
nothing I could do.  Just like you .
. . and Anakin.

            OBI-WAN
But if I had only --

She gently presses her fingers to his lips, shakes her head.

            PADMé
I don't understand it all, either,
but I know we did as much as we
could.  And now we have a future to
protect.

She gently places his hand on her abdomen.  He smiles slowly.
The ship jolts --

            PADMé
Uh-oh . . .

She helps Obi-Wan into the companionway.

                                                   117.

EXT. SPACE

Three Star Destroyers pursue them, firing.  Laser bolts EXPLODE
on the freighter's shields.  She desperately tries to evade
them, firing back.


INT. CORRELIAN FREIGHTER - COCKPIT

Obi-Wan and Padmé enter as the ship shakes from another pounding.
She helps Obi-Wan to a seat.  Yoda peers closely at the scopes.

            YODA
Hmn, persistent they are.

            CALRISSIAN
Accurate, too.  If you've got any
tricks left . . .

Yoda shuts his eyes.  Calrissian gives him a worried look.

            OBI-WAN
Master Yoda . . .

            YODA
Shhh . . . the Force must I become
one with.

            THREEPIO
Oh, I don't suppose you could do it
a bit more quick --

They all shush him, annoyed.


EXT. SPACE

The Star Destroyers close relentlessly.


INT. STAR DESTROYER BRIDGE - MAIN CONTROL DECK

The crew works their scopes as the Command Crew watches through
the huge view port.  Squat, evil-looking LIEUTENANT OZZEL
approaches the Commander.

            OZZEL
Commander Tarkin?

COMMANDER TARKIN, a thin, hatchet-faced man with cold eyes turns
impatiently.  Ozzel hurriedly salutes.

                                                   118.

            OZZEL
They'll be in tractor beam range in
a few moments.  Shall we attempt to
capture them?

            TARKIN
I don't think so.  No, my orders
were to see that they do not escape.
Lock on all weapons.  Prepare to fire.

Ozzel salutes and hurries away.  Tarkin turns to gaze through
the view port, hands clasped behind his back.


EXT. SPACE

The freighter is being overtaken by the largest Star Destroyer.
Laser bolts hammer the smaller ship.


INT. CORRELIAN FREIGHTER - COCKPIT

They're jolted by multiple shield hits.  ALARMS flash.  Padmé
shoots a worried glance at Calrissian.  Only Yoda seems calm.
Eyes shut, he breathes deeply, his head moving slightly . . .


INT. STAR DESTROYER BRIDGE - MAIN CONTROL DECK

Tarkin watches expectantly.  Behind him, a Gunnery Officer
suddenly starts, looks up, confused.


INT. CORELLIAN FREIGHTER - COCKPIT

Yoda tenses.  He gestures slightly, reaching out with the Force --


INT. STAR DESTROYER BRIDGE - MAIN CONTROL DECK

The Gunnery Officer suddenly reaches over and alters the weapons
lock.  Outside the view port, Tarkin sees the freighter caught
between his ship and another Star Destroyer.


EXT. SPACE

The pursuing Star Destroyer fires -- past the freighter -- and
hits the second Star Destroyer's control tower.  EXPLOSIONS
flare up on the superstructure.

                                                   119.

INT. CORRELIAN FREIGHTER - COCKPIT

They react, surprised.  Yoda opens his eyes.

            YODA
Now -- quickly -- jump!



INT. STAR DESTROYER BRIDGE - MAIN CONTROL DECK

Tarkin gapes, then spins to face Ozzel, red with rage.

TARKIN                           OZZEL
What the devil -- ?!             S-sir --

Tarkin spins around to the viewport --


EXT. SPACE

The freighter suddenly angles, and before anyone can intercept
them -- rockets into hyperspace.


EXT. CORUSCANT - IMPERIAL PALACE - DAY

A magnificent structure stands on the former site of the Jedi
Temple.  A huge statue of Palpatine dominates the main plaza.
Troopers patrol on foot and speeder bikes.


INT. IMPERIAL PALACE - DAY

Emperor Palpatine is surrounded by red-robed Guards and his
fawning ADVISORS.  DARTH VADER approaches the throne, wearing
the battle helmet and cloak.  He kneels.

            VADER
I beg of thee, Master, to allow me
to continue the hunt for the last
of the Jedi.

            PALPATINE
Patience, my friend.  Kenobi alone
remains.  When the time is right,
he will seek us out.

            VADER
Are you certain of this, my Master?

            PALPATINE
I have foreseen it!

                                                   120.

He chuckles.  Boba Fett and Commander Tarkin join them at the
throne.  The populace files into the throne room to pay homage
to their new ruler.  Palpatine beams from his throne.


EXT. SPACE - DAGOBAH

The mysterious planet hangs in the heavens, covered with dense
clouds.


EXT. DAGOBAH SWAMP - NIGHT

The freighter rests beneath a canopy of huge trees.  They've
been here for a while, a tiny base camp's set up around it.
Strange creatures sail through the trees, and swim through the
murky waters.  EERIE CRIES fill the night.


INT. CORRELIAN FREIGHTER - MAIN CABIN

Padmé lies on a bunk, holding two babies, only a few days old.
Yoda, Obi-Wan, Calrissian, Artoo, Threepio look on, beaming.
Artoo BEEPS softly.

            THREEPIO
My sentiments, exactly!  How
wonderful!  It's times like this
that almost make this whole
adventure worthwhile, although it's
not something I'd care to keep doing.

He puts a comradely hand on Artoo's dome.  Padmé coos softly to
the infants.

            OBI-WAN
They're beautiful.

            YODA
And strong with them is the Force.
A new hope, perhaps, they will be.

            PADMé
It will be a long time before we
have to face that.

            CALRISSIAN
Amen to that.  So, what're you
gonna call 'em?  Lando'd be a good
name for the boy.

Padmé considers a moment.  A soft smile wreathes her face.

                                                   121.

            PADMé
Luke . . . and Leia.


EXT. DAGOBAH SWAMP - NIGHT

Obi-Wan emerges from the ship, sees Yoda sitting nearby on a
large, twisted log.  Obi-Wan sits beside him.  Yoda scratches at
the muddy ground with his walking stick.  He gazes up at the
stars, visible through openings in the leafy canopy.

            OBI-WAN
You're certain the Sith won't come
here.

            YODA
Defeated here they were, ages ago.
Since then, return they will not.
And, here will I remain.

            OBI-WAN
Here?  But what about --

            YODA
No, Obi-Wan, past for now is the
time of the Jedi.

            OBI-WAN
I don't accept that.

            YODA
You must.  No more can we do.  All
now rests with them.

            OBI-WAN
I know you're right, but still . . .

He looks toward the frieghter.

            OBI-WAN
I wish we didn't have to separate
them.  She's already endured so much.

Yoda shuts his eyes and sighs.


EXT. ALDERAAN - SEASIDE PALACE - DAY

            YODA (VO)
Mmm.  We must.  Should one be
found, survive might the other.

Obi-Wan's starship flies over a vast sea that stretches to the
horizon.

                                                   122.

Beautiful, long-winged GULAKS soar and CRY above the gentle waves.


EXT. BEACH - DAY

Padmé sits with an infant Leia on the pink sand, humming softly.
She looks up at the sky with a touch of sadness.


INT. PALACE VERANDA - DAY

Obi-Wan and Bail Organa watch.  Obi-Wan looks away, experiencing
a pang of regret.  He glances toward Threepio and Artoo.
Threepio's engaged in another lecture, which Artoo endures
patiently.

            OBI-WAN
What about them?

            BAIL ORGANA
We've flushed Threepio's memory.  I
think we can trust Artoo to keep
silent, and he's very resourceful.

            OBI-WAN
If you ever have need of me, send
him to me on Tatooine.

            BAIL ORGANA
Is that where you'll take Luke?
Isn't it dangerous?

            OBI-WAN
Anakin's brother-in-law and his
wife live there.  The Empire won't
bother with it, it's too
inconsequential . . .


EXT. SPACE - TATOOINE

The giant yellow planet gleams in the light of its twin suns.

            OBI-WAN (VO)
. . . Too far from the bright
center of the universe.


EXT. TATOOINE - LARS HOMESTEAD - DAY

BERU LARS holds baby Luke, cooing happily.  Luke smiles and
gurgles at her, wrapped in a blanket.  Off to one side, Obi-Wan,
in desert robes, stands with the scowling OWEN LARS.

                                                   123.

            OWEN
You're sure it's over?  We've had
more than enough of this . . .

He lets it hang.  Obi-Wan watches Beru and the baby a moment,
then pulls his hood up.

            OWEN
I think it would probably be best
if you left Tatooine.  For the
boy's sake.

            OBI-WAN
Don't worry about me.  Ben Kenobi
will be just another reclusive
desert rat.  You won't even know
I'm here.

Owen shakes his head, muttering.  Obi-Wan allows himself a small
smile.  He takes a final look at the homestead, at Beru and the
baby.  She waves Luke's little hand.

They watch Ben Kenobi . . . last of the Jedi knights . . . turn
and walk into Tatooine's endless dune seas.

IRIS OUT.

                  THE END.
*/