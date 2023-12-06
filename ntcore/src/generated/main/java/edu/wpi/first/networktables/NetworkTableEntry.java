// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// THIS FILE WAS AUTO-GENERATED BY ./ntcore/generate_topics.py. DO NOT MODIFY

package edu.wpi.first.networktables;

import java.nio.ByteBuffer;

/**
 * NetworkTables Entry.
 *
 * <p>For backwards compatibility, the NetworkTableEntry close() does not release the entry.
 */
@SuppressWarnings("UnnecessaryParentheses")
public final class NetworkTableEntry implements Publisher, Subscriber {
  /**
   * Flag values (as returned by {@link #getFlags()}).
   *
   * @deprecated Use isPersistent() instead.
   */
  @Deprecated(since = "2022", forRemoval = true)
  public static final int kPersistent = 0x01;

  /**
   * Construct from native handle.
   *
   * @param inst Instance
   * @param handle Native handle
   */
  public NetworkTableEntry(NetworkTableInstance inst, int handle) {
    this(new Topic(inst, NetworkTablesJNI.getTopicFromHandle(handle)), handle);
  }

  /**
   * Construct from native handle.
   *
   * @param topic Topic
   * @param handle Native handle
   */
  public NetworkTableEntry(Topic topic, int handle) {
    m_topic = topic;
    m_handle = handle;
  }

  @Override
  public void close() {}

  /**
   * Determines if the native handle is valid.
   *
   * @return True if the native handle is valid, false otherwise.
   */
  @Override
  public boolean isValid() {
    return m_handle != 0;
  }

  /**
   * Gets the native handle for the entry.
   *
   * @return Native handle
   */
  @Override
  public int getHandle() {
    return m_handle;
  }

  /**
   * Gets the subscribed-to / published-to topic.
   *
   * @return Topic
   */
  @Override
  public Topic getTopic() {
    return m_topic;
  }

  /**
   * Gets the instance for the entry.
   *
   * @return Instance
   */
  public NetworkTableInstance getInstance() {
    return m_topic.getInstance();
  }

  /**
   * Determines if the entry currently exists.
   *
   * @return True if the entry exists, false otherwise.
   */
  @Override
  public boolean exists() {
    return NetworkTablesJNI.getType(m_handle) != 0;
  }

  /**
   * Gets the name of the entry (the key).
   *
   * @return the entry's name
   */
  public String getName() {
    return NetworkTablesJNI.getEntryName(m_handle);
  }

  /**
   * Gets the type of the entry.
   *
   * @return the entry's type
   */
  public NetworkTableType getType() {
    return NetworkTableType.getFromInt(NetworkTablesJNI.getType(m_handle));
  }

  /**
   * Returns the flags.
   *
   * @return the flags (bitmask)
   * @deprecated Use isPersistent() or topic properties instead
   */
  @Deprecated(since = "2022", forRemoval = true)
  public int getFlags() {
    return NetworkTablesJNI.getEntryFlags(m_handle);
  }

  /**
   * Gets the last time the entry's value was changed.
   *
   * @return Entry last change time
   */
  @Override
  public long getLastChange() {
    return NetworkTablesJNI.getEntryLastChange(m_handle);
  }

  /**
   * Gets the entry's value. Returns a value with type NetworkTableType.kUnassigned if the value
   * does not exist.
   *
   * @return the entry's value
   */
  public NetworkTableValue getValue() {
    return NetworkTablesJNI.getValue(m_handle);
  }

  /**
   * Gets the entry's value as a boolean. If the entry does not exist or is of different type, it
   * will return the default value.
   *
   * @param defaultValue the value to be returned if no value is found
   * @return the entry's value or the given default value
   */
  public boolean getBoolean(boolean defaultValue) {
    return NetworkTablesJNI.getBoolean(m_handle, defaultValue);
  }

  /**
   * Gets the entry's value as a long. If the entry does not exist or is of different type, it
   * will return the default value.
   *
   * @param defaultValue the value to be returned if no value is found
   * @return the entry's value or the given default value
   */
  public long getInteger(long defaultValue) {
    return NetworkTablesJNI.getInteger(m_handle, defaultValue);
  }

  /**
   * Gets the entry's value as a float. If the entry does not exist or is of different type, it
   * will return the default value.
   *
   * @param defaultValue the value to be returned if no value is found
   * @return the entry's value or the given default value
   */
  public float getFloat(float defaultValue) {
    return NetworkTablesJNI.getFloat(m_handle, defaultValue);
  }

  /**
   * Gets the entry's value as a double. If the entry does not exist or is of different type, it
   * will return the default value.
   *
   * @param defaultValue the value to be returned if no value is found
   * @return the entry's value or the given default value
   */
  public double getDouble(double defaultValue) {
    return NetworkTablesJNI.getDouble(m_handle, defaultValue);
  }

  /**
   * Gets the entry's value as a String. If the entry does not exist or is of different type, it
   * will return the default value.
   *
   * @param defaultValue the value to be returned if no value is found
   * @return the entry's value or the given default value
   */
  public String getString(String defaultValue) {
    return NetworkTablesJNI.getString(m_handle, defaultValue);
  }

  /**
   * Gets the entry's value as a byte[]. If the entry does not exist or is of different type, it
   * will return the default value.
   *
   * @param defaultValue the value to be returned if no value is found
   * @return the entry's value or the given default value
   */
  public byte[] getRaw(byte[] defaultValue) {
    return NetworkTablesJNI.getRaw(m_handle, defaultValue);
  }

  /**
   * Gets the entry's value as a boolean[]. If the entry does not exist or is of different type, it
   * will return the default value.
   *
   * @param defaultValue the value to be returned if no value is found
   * @return the entry's value or the given default value
   */
  public boolean[] getBooleanArray(boolean[] defaultValue) {
    return NetworkTablesJNI.getBooleanArray(m_handle, defaultValue);
  }

  /**
   * Gets the entry's value as a boolean array. If the entry does not exist or is of different type,
   * it will return the default value.
   *
   * @param defaultValue the value to be returned if no value is found
   * @return the entry's value or the given default value
   */
  public Boolean[] getBooleanArray(Boolean[] defaultValue) {
    return NetworkTableValue.fromNativeBooleanArray(
        getBooleanArray(NetworkTableValue.toNativeBooleanArray(defaultValue)));
  }

  /**
   * Gets the entry's value as a long[]. If the entry does not exist or is of different type, it
   * will return the default value.
   *
   * @param defaultValue the value to be returned if no value is found
   * @return the entry's value or the given default value
   */
  public long[] getIntegerArray(long[] defaultValue) {
    return NetworkTablesJNI.getIntegerArray(m_handle, defaultValue);
  }

  /**
   * Gets the entry's value as a boolean array. If the entry does not exist or is of different type,
   * it will return the default value.
   *
   * @param defaultValue the value to be returned if no value is found
   * @return the entry's value or the given default value
   */
  public Long[] getIntegerArray(Long[] defaultValue) {
    return NetworkTableValue.fromNativeIntegerArray(
        getIntegerArray(NetworkTableValue.toNativeIntegerArray(defaultValue)));
  }

  /**
   * Gets the entry's value as a float[]. If the entry does not exist or is of different type, it
   * will return the default value.
   *
   * @param defaultValue the value to be returned if no value is found
   * @return the entry's value or the given default value
   */
  public float[] getFloatArray(float[] defaultValue) {
    return NetworkTablesJNI.getFloatArray(m_handle, defaultValue);
  }

  /**
   * Gets the entry's value as a boolean array. If the entry does not exist or is of different type,
   * it will return the default value.
   *
   * @param defaultValue the value to be returned if no value is found
   * @return the entry's value or the given default value
   */
  public Float[] getFloatArray(Float[] defaultValue) {
    return NetworkTableValue.fromNativeFloatArray(
        getFloatArray(NetworkTableValue.toNativeFloatArray(defaultValue)));
  }

  /**
   * Gets the entry's value as a double[]. If the entry does not exist or is of different type, it
   * will return the default value.
   *
   * @param defaultValue the value to be returned if no value is found
   * @return the entry's value or the given default value
   */
  public double[] getDoubleArray(double[] defaultValue) {
    return NetworkTablesJNI.getDoubleArray(m_handle, defaultValue);
  }

  /**
   * Gets the entry's value as a boolean array. If the entry does not exist or is of different type,
   * it will return the default value.
   *
   * @param defaultValue the value to be returned if no value is found
   * @return the entry's value or the given default value
   */
  public Double[] getDoubleArray(Double[] defaultValue) {
    return NetworkTableValue.fromNativeDoubleArray(
        getDoubleArray(NetworkTableValue.toNativeDoubleArray(defaultValue)));
  }

  /**
   * Gets the entry's value as a String[]. If the entry does not exist or is of different type, it
   * will return the default value.
   *
   * @param defaultValue the value to be returned if no value is found
   * @return the entry's value or the given default value
   */
  public String[] getStringArray(String[] defaultValue) {
    return NetworkTablesJNI.getStringArray(m_handle, defaultValue);
  }

  /**
   * Gets the entry's value as a double. If the entry does not exist or is of different type, it
   * will return the default value.
   *
   * @param defaultValue the value to be returned if no value is found
   * @return the entry's value or the given default value
   */
  public Number getNumber(Number defaultValue) {
    return getDouble(defaultValue.doubleValue());
  }

  /**
   * Gets the entry's value as a double array. If the entry does not exist or is of different type,
   * it will return the default value.
   *
   * @param defaultValue the value to be returned if no value is found
   * @return the entry's value or the given default value
   */
  public Number[] getNumberArray(Number[] defaultValue) {
    return NetworkTableValue.fromNativeDoubleArray(
        getDoubleArray(NetworkTableValue.toNativeDoubleArray(defaultValue)));
  }

  /**
   * Get an array of all value changes since the last call to readQueue.
   *
   * <p>The "poll storage" subscribe option can be used to set the queue
   * depth.
   *
   * @return Array of values; empty array if no new changes have been
   *     published since the previous call.
   */
  public NetworkTableValue[] readQueue() {
    return NetworkTablesJNI.readQueueValue(m_handle);
  }

  /**
   * Checks if a data value is of a type that can be placed in a NetworkTable entry.
   *
   * @param data the data to check
   * @return true if the data can be placed in an entry, false if it cannot
   */
  public static boolean isValidDataType(Object data) {
    return data instanceof Number
        || data instanceof Boolean
        || data instanceof String
        || data instanceof long[]
        || data instanceof Long[]
        || data instanceof float[]
        || data instanceof Float[]
        || data instanceof double[]
        || data instanceof Double[]
        || data instanceof Number[]
        || data instanceof boolean[]
        || data instanceof Boolean[]
        || data instanceof String[]
        || data instanceof byte[]
        || data instanceof Byte[];
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   * @throws IllegalArgumentException if the value is not a known type
   */
  public boolean setDefaultValue(Object defaultValue) {
    if (defaultValue instanceof NetworkTableValue) {
      long time = ((NetworkTableValue) defaultValue).getTime();
      Object otherValue = ((NetworkTableValue) defaultValue).getValue();
      switch (((NetworkTableValue) defaultValue).getType()) {
        case kBoolean:
          return NetworkTablesJNI.setDefaultBoolean(m_handle, time, (Boolean) otherValue);
        case kInteger:
          return NetworkTablesJNI.setDefaultInteger(
              m_handle, time, ((Number) otherValue).longValue());
        case kFloat:
          return NetworkTablesJNI.setDefaultFloat(
              m_handle, time, ((Number) otherValue).floatValue());
        case kDouble:
          return NetworkTablesJNI.setDefaultDouble(
              m_handle, time, ((Number) otherValue).doubleValue());
        case kString:
          return NetworkTablesJNI.setDefaultString(m_handle, time, (String) otherValue);
        case kRaw:
          return NetworkTablesJNI.setDefaultRaw(m_handle, time, (byte[]) otherValue);
        case kBooleanArray:
          return NetworkTablesJNI.setDefaultBooleanArray(m_handle, time, (boolean[]) otherValue);
        case kIntegerArray:
          return NetworkTablesJNI.setDefaultIntegerArray(m_handle, time, (long[]) otherValue);
        case kFloatArray:
          return NetworkTablesJNI.setDefaultFloatArray(m_handle, time, (float[]) otherValue);
        case kDoubleArray:
          return NetworkTablesJNI.setDefaultDoubleArray(m_handle, time, (double[]) otherValue);
        case kStringArray:
          return NetworkTablesJNI.setDefaultStringArray(m_handle, time, (String[]) otherValue);
        default:
          return true;
      }
    } else if (defaultValue instanceof Boolean) {
      return setDefaultBoolean((Boolean) defaultValue);
    } else if (defaultValue instanceof Integer) {
      return setDefaultInteger((Integer) defaultValue);
    } else if (defaultValue instanceof Float) {
      return setDefaultFloat((Float) defaultValue);
    } else if (defaultValue instanceof Number) {
      return setDefaultNumber((Number) defaultValue);
    } else if (defaultValue instanceof String) {
      return setDefaultString((String) defaultValue);
    } else if (defaultValue instanceof byte[]) {
      return setDefaultRaw((byte[]) defaultValue);
    } else if (defaultValue instanceof boolean[]) {
      return setDefaultBooleanArray((boolean[]) defaultValue);
    } else if (defaultValue instanceof long[]) {
      return setDefaultIntegerArray((long[]) defaultValue);
    } else if (defaultValue instanceof float[]) {
      return setDefaultFloatArray((float[]) defaultValue);
    } else if (defaultValue instanceof double[]) {
      return setDefaultDoubleArray((double[]) defaultValue);
    } else if (defaultValue instanceof Boolean[]) {
      return setDefaultBooleanArray((Boolean[]) defaultValue);
    } else if (defaultValue instanceof Long[]) {
      return setDefaultIntegerArray((Long[]) defaultValue);
    } else if (defaultValue instanceof Float[]) {
      return setDefaultFloatArray((Float[]) defaultValue);
    } else if (defaultValue instanceof Number[]) {
      return setDefaultNumberArray((Number[]) defaultValue);
    } else if (defaultValue instanceof String[]) {
      return setDefaultStringArray((String[]) defaultValue);
    } else {
      throw new IllegalArgumentException(
          "Value of type " + defaultValue.getClass().getName() + " cannot be put into a table");
    }
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultBoolean(boolean defaultValue) {
    return NetworkTablesJNI.setDefaultBoolean(m_handle, 0, defaultValue);
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultInteger(long defaultValue) {
    return NetworkTablesJNI.setDefaultInteger(m_handle, 0, defaultValue);
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultFloat(float defaultValue) {
    return NetworkTablesJNI.setDefaultFloat(m_handle, 0, defaultValue);
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultDouble(double defaultValue) {
    return NetworkTablesJNI.setDefaultDouble(m_handle, 0, defaultValue);
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultString(String defaultValue) {
    return NetworkTablesJNI.setDefaultString(m_handle, 0, defaultValue);
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultRaw(byte[] defaultValue) {
    return NetworkTablesJNI.setDefaultRaw(m_handle, 0, defaultValue);
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set; will send from defaultValue.position() to
   *                     defaultValue.capacity()
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultRaw(ByteBuffer defaultValue) {
    return NetworkTablesJNI.setDefaultRaw(m_handle, 0, defaultValue);
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @param start Start position of data (in buffer)
   * @param len Length of data (must be less than or equal to value.length - start)
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultRaw(byte[] defaultValue, int start, int len) {
    return NetworkTablesJNI.setDefaultRaw(m_handle, 0, defaultValue, start, len);
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @param start Start position of data (in buffer)
   * @param len Length of data (must be less than or equal to value.capacity() - start)
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultRaw(ByteBuffer defaultValue, int start, int len) {
    return NetworkTablesJNI.setDefaultRaw(m_handle, 0, defaultValue, start, len);
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultBooleanArray(boolean[] defaultValue) {
    return NetworkTablesJNI.setDefaultBooleanArray(m_handle, 0, defaultValue);
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultBooleanArray(Boolean[] defaultValue) {
    return setDefaultBooleanArray(NetworkTableValue.toNativeBooleanArray(defaultValue));
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultIntegerArray(long[] defaultValue) {
    return NetworkTablesJNI.setDefaultIntegerArray(m_handle, 0, defaultValue);
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultIntegerArray(Long[] defaultValue) {
    return setDefaultIntegerArray(NetworkTableValue.toNativeIntegerArray(defaultValue));
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultFloatArray(float[] defaultValue) {
    return NetworkTablesJNI.setDefaultFloatArray(m_handle, 0, defaultValue);
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultFloatArray(Float[] defaultValue) {
    return setDefaultFloatArray(NetworkTableValue.toNativeFloatArray(defaultValue));
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultDoubleArray(double[] defaultValue) {
    return NetworkTablesJNI.setDefaultDoubleArray(m_handle, 0, defaultValue);
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultDoubleArray(Double[] defaultValue) {
    return setDefaultDoubleArray(NetworkTableValue.toNativeDoubleArray(defaultValue));
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultStringArray(String[] defaultValue) {
    return NetworkTablesJNI.setDefaultStringArray(m_handle, 0, defaultValue);
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultNumber(Number defaultValue) {
    return setDefaultDouble(defaultValue.doubleValue());
  }

  /**
   * Sets the entry's value if it does not exist.
   *
   * @param defaultValue the default value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDefaultNumberArray(Number[] defaultValue) {
    return setDefaultDoubleArray(NetworkTableValue.toNativeDoubleArray(defaultValue));
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value that will be assigned
   * @return False if the table key already exists with a different type
   * @throws IllegalArgumentException if the value is not a known type
   */
  public boolean setValue(Object value) {
    if (value instanceof NetworkTableValue) {
      long time = ((NetworkTableValue) value).getTime();
      Object otherValue = ((NetworkTableValue) value).getValue();
      switch (((NetworkTableValue) value).getType()) {
        case kBoolean:
          return NetworkTablesJNI.setBoolean(m_handle, time, (Boolean) otherValue);
        case kInteger:
          return NetworkTablesJNI.setInteger(
              m_handle, time, ((Number) otherValue).longValue());
        case kFloat:
          return NetworkTablesJNI.setFloat(
              m_handle, time, ((Number) otherValue).floatValue());
        case kDouble:
          return NetworkTablesJNI.setDouble(
              m_handle, time, ((Number) otherValue).doubleValue());
        case kString:
          return NetworkTablesJNI.setString(m_handle, time, (String) otherValue);
        case kRaw:
          return NetworkTablesJNI.setRaw(m_handle, time, (byte[]) otherValue);
        case kBooleanArray:
          return NetworkTablesJNI.setBooleanArray(m_handle, time, (boolean[]) otherValue);
        case kIntegerArray:
          return NetworkTablesJNI.setIntegerArray(m_handle, time, (long[]) otherValue);
        case kFloatArray:
          return NetworkTablesJNI.setFloatArray(m_handle, time, (float[]) otherValue);
        case kDoubleArray:
          return NetworkTablesJNI.setDoubleArray(m_handle, time, (double[]) otherValue);
        case kStringArray:
          return NetworkTablesJNI.setStringArray(m_handle, time, (String[]) otherValue);
        default:
          return true;
      }
    } else if (value instanceof Boolean) {
      return setBoolean((Boolean) value);
    } else if (value instanceof Long) {
      return setInteger((Long) value);
    } else if (value instanceof Float) {
      return setFloat((Float) value);
    } else if (value instanceof Number) {
      return setNumber((Number) value);
    } else if (value instanceof String) {
      return setString((String) value);
    } else if (value instanceof byte[]) {
      return setRaw((byte[]) value);
    } else if (value instanceof boolean[]) {
      return setBooleanArray((boolean[]) value);
    } else if (value instanceof long[]) {
      return setIntegerArray((long[]) value);
    } else if (value instanceof float[]) {
      return setFloatArray((float[]) value);
    } else if (value instanceof double[]) {
      return setDoubleArray((double[]) value);
    } else if (value instanceof Boolean[]) {
      return setBooleanArray((Boolean[]) value);
    } else if (value instanceof Long[]) {
      return setIntegerArray((Long[]) value);
    } else if (value instanceof Float[]) {
      return setFloatArray((Float[]) value);
    } else if (value instanceof Number[]) {
      return setNumberArray((Number[]) value);
    } else if (value instanceof String[]) {
      return setStringArray((String[]) value);
    } else {
      throw new IllegalArgumentException(
          "Value of type " + value.getClass().getName() + " cannot be put into a table");
    }
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @return False if the entry exists with a different type
   */
  public boolean setBoolean(boolean value) {
    return NetworkTablesJNI.setBoolean(m_handle, 0, value);
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @return False if the entry exists with a different type
   */
  public boolean setInteger(long value) {
    return NetworkTablesJNI.setInteger(m_handle, 0, value);
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @return False if the entry exists with a different type
   */
  public boolean setFloat(float value) {
    return NetworkTablesJNI.setFloat(m_handle, 0, value);
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDouble(double value) {
    return NetworkTablesJNI.setDouble(m_handle, 0, value);
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @return False if the entry exists with a different type
   */
  public boolean setString(String value) {
    return NetworkTablesJNI.setString(m_handle, 0, value);
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @return False if the entry exists with a different type
   */
  public boolean setRaw(byte[] value) {
    return NetworkTablesJNI.setRaw(m_handle, 0, value);
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set; will send from value.position() to value.capacity()
   * @return False if the entry exists with a different type
   */
  public boolean setRaw(ByteBuffer value) {
    return NetworkTablesJNI.setRaw(m_handle, 0, value);
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @param start Start position of data (in buffer)
   * @param len Length of data (must be less than or equal to value.length - start)
   * @return False if the entry exists with a different type
   */
  public boolean setRaw(byte[] value, int start, int len) {
    return NetworkTablesJNI.setRaw(m_handle, 0, value, start, len);
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @param start Start position of data (in buffer)
   * @param len Length of data (must be less than or equal to value.capacity() - start)
   * @return False if the entry exists with a different type
   */
  public boolean setRaw(ByteBuffer value, int start, int len) {
    return NetworkTablesJNI.setRaw(m_handle, 0, value, start, len);
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @return False if the entry exists with a different type
   */
  public boolean setBooleanArray(boolean[] value) {
    return NetworkTablesJNI.setBooleanArray(m_handle, 0, value);
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @return False if the entry exists with a different type
   */
  public boolean setBooleanArray(Boolean[] value) {
    return setBooleanArray(NetworkTableValue.toNativeBooleanArray(value));
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @return False if the entry exists with a different type
   */
  public boolean setIntegerArray(long[] value) {
    return NetworkTablesJNI.setIntegerArray(m_handle, 0, value);
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @return False if the entry exists with a different type
   */
  public boolean setIntegerArray(Long[] value) {
    return setIntegerArray(NetworkTableValue.toNativeIntegerArray(value));
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @return False if the entry exists with a different type
   */
  public boolean setFloatArray(float[] value) {
    return NetworkTablesJNI.setFloatArray(m_handle, 0, value);
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @return False if the entry exists with a different type
   */
  public boolean setFloatArray(Float[] value) {
    return setFloatArray(NetworkTableValue.toNativeFloatArray(value));
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDoubleArray(double[] value) {
    return NetworkTablesJNI.setDoubleArray(m_handle, 0, value);
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @return False if the entry exists with a different type
   */
  public boolean setDoubleArray(Double[] value) {
    return setDoubleArray(NetworkTableValue.toNativeDoubleArray(value));
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @return False if the entry exists with a different type
   */
  public boolean setStringArray(String[] value) {
    return NetworkTablesJNI.setStringArray(m_handle, 0, value);
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @return False if the entry exists with a different type
   */
  public boolean setNumber(Number value) {
    return setDouble(value.doubleValue());
  }

  /**
   * Sets the entry's value.
   *
   * @param value the value to set
   * @return False if the entry exists with a different type
   */
  public boolean setNumberArray(Number[] value) {
    return setDoubleArray(NetworkTableValue.toNativeDoubleArray(value));
  }

  /**
   * Sets flags.
   *
   * @param flags the flags to set (bitmask)
   * @deprecated Use setPersistent() or topic properties instead
   */
  @Deprecated(since = "2022", forRemoval = true)
  public void setFlags(int flags) {
    NetworkTablesJNI.setEntryFlags(m_handle, getFlags() | flags);
  }

  /**
   * Clears flags.
   *
   * @param flags the flags to clear (bitmask)
   * @deprecated Use setPersistent() or topic properties instead
   */
  @Deprecated(since = "2022", forRemoval = true)
  public void clearFlags(int flags) {
    NetworkTablesJNI.setEntryFlags(m_handle, getFlags() & ~flags);
  }

  /** Make value persistent through program restarts. */
  public void setPersistent() {
    NetworkTablesJNI.setTopicPersistent(m_topic.getHandle(), true);
  }

  /** Stop making value persistent through program restarts. */
  public void clearPersistent() {
    NetworkTablesJNI.setTopicPersistent(m_topic.getHandle(), false);
  }

  /**
   * Returns whether the value is persistent through program restarts.
   *
   * @return True if the value is persistent.
   */
  public boolean isPersistent() {
    return NetworkTablesJNI.getTopicPersistent(m_topic.getHandle());
  }

  /** Stops publishing the entry if it's been published. */
  public void unpublish() {
    NetworkTablesJNI.unpublish(m_handle);
  }

  /**
   * Deletes the entry.
   *
   * @deprecated Use unpublish() instead.
   */
  @Deprecated(since = "2022", forRemoval = true)
  public void delete() {
    unpublish();
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if (!(other instanceof NetworkTableEntry)) {
      return false;
    }

    return m_handle == ((NetworkTableEntry) other).m_handle;
  }

  @Override
  public int hashCode() {
    return m_handle;
  }

  private final Topic m_topic;
  protected int m_handle;
}